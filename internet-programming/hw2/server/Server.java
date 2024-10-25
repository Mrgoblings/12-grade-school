package hw2.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int PORT = 31337;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        AsynchronousChannelGroup channelGroup = AsynchronousChannelGroup.withThreadPool(threadPool);

        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open(channelGroup).bind(new InetSocketAddress(PORT));
        System.out.println("Server started on port " + PORT);

        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Void attachment) {
                server.accept(null, this);

                handleClient(client);
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.err.println("Failed to accept a client: " + exc.getMessage());
            }
        });

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(AsynchronousSocketChannel client) {
        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);

        try {
            Path filePath = Paths.get("received_" + System.currentTimeMillis() + ".txt");

            client.read(buffer, filePath, new CompletionHandler<>() {
                @Override
                public void completed(Integer bytesRead, Path filePath) {
                    if (bytesRead > 0) {
                        buffer.flip();
                        try {
                            Files.write(filePath, buffer.array(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        buffer.clear();

                        client.read(buffer, filePath, this);
                    } else {
                        try {
                            System.out.println("File received: " + filePath.toString());
                            client.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void failed(Throwable exc, Path filePath) {
                    System.err.println("Failed to read file from client: " + exc.getMessage());
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
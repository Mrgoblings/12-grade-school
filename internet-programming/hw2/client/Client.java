package hw2.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Client {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 31337;
    // private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) throws IOException, InterruptedException {
        Path filePath = Paths.get("file.txt");
        if (!Files.exists(filePath)) {
            System.out.println("File does not exist: " + filePath);
            return;
        }

        AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open();
        Future<Void> future = clientChannel.connect(new java.net.InetSocketAddress(SERVER_ADDRESS, PORT));

        // Wait for the connection to be established
        

        try {
            future.get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        sendFile(clientChannel, filePath);
    }

    private static void sendFile(AsynchronousSocketChannel clientChannel, Path filePath) throws IOException {
        byte[] fileData = Files.readAllBytes(filePath);
        ByteBuffer buffer = ByteBuffer.wrap(fileData);

        clientChannel.write(buffer, buffer, new CompletionHandler<>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (attachment.hasRemaining()) {
                    clientChannel.write(attachment, attachment, this);
                } else {
                    try {
                        System.out.println("File sent successfully: " + filePath);
                        clientChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.err.println("Failed to send file: " + exc.getMessage());
                try {
                    clientChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

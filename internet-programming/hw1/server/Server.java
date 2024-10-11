package hw1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Server {
    private static volatile boolean isRunning = true; 

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(31337)) {
            System.out.println("Server started on port 31337");
            System.out.println("Type 'EXIT' to shut down the server safely.");

            Thread shutdownThread = new Thread(() -> {
                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    while (isRunning) {
                        String command = consoleReader.readLine();
                        if ("EXIT".equalsIgnoreCase(command)) {
                            isRunning = false;
                            System.out.println("Shutting down server...");
                            serverSocket.close(); 
                            pool.shutdown(); 
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            shutdownThread.start();

            while (isRunning) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected");
                    pool.execute(new ClientHandler(clientSocket));
                } catch (IOException e) {
                    if (!isRunning) {
                        System.out.println("Server stopped accepting new clients.");
                    } else {
                        e.printStackTrace();
                    }
                }
            }

            try {
                pool.awaitTermination(2, TimeUnit.SECONDS);
                System.out.println("Server shutdown complete.");
            } catch (InterruptedException e) {
                System.err.println("Termination interrupted: " + e.getMessage());
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package server;
import java.io.*;
import java.net.*;
import java.util.concurrent.*;

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
                        if (command.equalsIgnoreCase("EXIT")) {
                            isRunning = false;
                            System.out.println("Shutting down server...");
                            serverSocket.close(); 
                            pool.shutdownNow(); 
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

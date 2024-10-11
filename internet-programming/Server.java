import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class Server {
    private static final String FILE_NAME = "students.txt";
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

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String request;
                while ((request = in.readLine()) != null) {
                    if (request.startsWith("ADD")) {
                        addStudent(request, out);
                    } else if (request.equals("VIEW")) {
                        viewAllStudents(out);
                    } else if (request.equals("AVERAGE")) {
                        calculateAverage(out);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private synchronized void addStudent(String request, PrintWriter out) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(request.substring(4)); 
                writer.newLine();
                out.println("Student added successfully.");
            } catch (IOException e) {
                out.println("Error adding student.");
            }
        }

        private synchronized void viewAllStudents(PrintWriter out) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    out.println(line);
                }
                out.println("END"); // Signal end of the data.
            } catch (IOException e) {
                out.println("Error reading students.");
            }
        }

        private synchronized void calculateAverage(PrintWriter out) {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                int totalGrades = 0;
                int gradeCount = 0;

                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    for (int i = 1; i < data.length; i++) {
                        totalGrades += Integer.parseInt(data[i]);
                        gradeCount++;
                    }
                }
                if (gradeCount > 0) {
                    double average = (double) totalGrades / gradeCount;
                    out.println("Average grade: " + String.format("%.2f", average)); 
                } else {
                    out.println("No grades available.");
                }
            } catch (IOException e) {
                out.println("Error calculating average.");
            }
        }
    }
}

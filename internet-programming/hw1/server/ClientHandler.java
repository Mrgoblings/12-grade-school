package hw1.server;
import java.io.*;
import java.net.*;

public class ClientHandler implements Runnable {
    private static final String FILE_NAME = "students.txt";
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
                } else if (request.equalsIgnoreCase("DISCONNECT")) {
                    out.println("DISCONNECT");
                    System.out.println("Client disconnected.");
                    break;
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
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            out.println("No student data available.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            out.println("No student data available.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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

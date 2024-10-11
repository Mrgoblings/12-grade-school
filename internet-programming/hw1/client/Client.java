package hw1.client;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 31337);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader inputBuff = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server");

            String request;
            while (true) {
                System.out.println("Enter request (ADD, VIEW, AVERAGE) or 'EXIT' to quit:");
                request = inputBuff.readLine();

                if ("EXIT".equalsIgnoreCase(request)) {
                    out.println("DISCONNECT"); 
                    break;
                }

                if (request.equalsIgnoreCase("ADD")) {
                    System.out.println("Enter student data in the format 'name,grade1,grade2,...'");
                    String studentData = inputBuff.readLine();
                    out.println("ADD " + studentData);
                } else if (request.equalsIgnoreCase("VIEW")) {
                    out.println("VIEW");
                } else if (request.equalsIgnoreCase("AVERAGE")) {
                    out.println("AVERAGE");
                } else {
                    System.out.println("Invalid request. Please enter 'ADD', 'VIEW', 'AVERAGE', or 'EXIT'.");
                }

                String response;
                while ((response = in.readLine()) != null && !response.equals("END")) {
                    if (response.equalsIgnoreCase("DISCONNECT")) {
                        System.out.println("Disconnected from the server.");
                        return;
                    }
                    System.out.println(response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 31337);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Connected to server");

            String request;
            while (true) {
                System.out.println("Enter request (ADD, VIEW, AVERAGE) or 'exit' to quit:");
                request = console.readLine();

                if (request.equalsIgnoreCase("exit")) {
                    break;
                }

                if (request.startsWith("ADD")) {
                    System.out.println("Enter student data in format: name,grade1,grade2,...");
                    String studentData = console.readLine();
                    out.println("ADD " + studentData);
                } else if (request.equalsIgnoreCase("VIEW")) {
                    out.println("VIEW");
                } else if (request.equalsIgnoreCase("AVERAGE")) {
                    out.println("AVERAGE");
                }

                String response;
                while ((response = in.readLine()) != null && !response.equals("END")) {
                    System.out.println(response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

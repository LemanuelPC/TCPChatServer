package io.codeforall.javatars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        Socket clientSocket = null;

        try {
            clientSocket = new Socket(hostName, portNumber);

            String message = getMessage();

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            out.print(message);
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line = "";
            String text = "";
            while ((line = in.readLine()) != null){
                text += line + "\n";
            }
            System.out.println(text);

            in.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getMessage() {

        Scanner reader = new Scanner(System.in);
        System.out.println("Message to be sent: ");
        return reader.nextLine();

    }
}

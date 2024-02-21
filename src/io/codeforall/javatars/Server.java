package io.codeforall.javatars;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int portNumber = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server initiated at IP: " + serverSocket.getInetAddress() + ":" + serverSocket.getLocalPort());
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client accepted: " + clientSocket.getInetAddress() + ":" + clientSocket.getLocalPort());
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String line = "";
            String text = "";
            line = in.readLine();
            System.out.println(line);
            /*while ((line = in.readLine()) != null){
                text += line + "\n";
            }
            */

            out.print(text);
            out.flush();
            System.out.println(text);

            in.close();
            out.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }
}

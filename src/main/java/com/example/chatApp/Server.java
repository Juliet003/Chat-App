package com.example.chatApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Waiting for client request");
        ServerSocket ss = new ServerSocket(9001);
        while (true) {
            Socket so = ss.accept();
            System.out.println("Connection established");

            Runnable clientHandler = new ClientHandler(so);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}






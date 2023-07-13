package javaExamples.topics.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerScoketEg {
    public static final short PORT = 9999;
    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket clientSocket;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Listening for connections at " + serverSocket.getInetAddress() + " and port " + PORT);
            while((clientSocket = serverSocket.accept()) != null ) {
                System.out.println("Listening for connections at " + serverSocket.getInetAddress() + " and port " + PORT);
                process(clientSocket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void process(Socket s) throws IOException {
        System.out.println("Accept from client : " + s.getInetAddress());
        s.close();
    }
}

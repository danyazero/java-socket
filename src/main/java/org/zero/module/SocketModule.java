package org.zero.module;

import java.io.*;
import java.net.Socket;

public class SocketModule {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader in;
    private static BufferedWriter out;

    public SocketModule(int port) throws IOException {
        clientSocket = new Socket("localhost", port);
    }

    public SocketModule(Socket socket) {
        clientSocket = socket;
    }

    public SocketModule connect() throws IOException {
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        return this;
    }

    public void sendMessageToServer(String message) throws IOException {
        out.write(message + "\n");
        out.flush();
    }

    public String getMessageFromServer() throws IOException {
        return in.readLine();
    }

    public void close() throws IOException {
        clientSocket.close();
        in.close();
        out.close();
    }


}

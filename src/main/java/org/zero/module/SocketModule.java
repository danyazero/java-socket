package org.zero.module;

import java.io.*;
import java.net.Socket;

public class SocketModule {

    private static Socket clientSocket; // сокет для общения
    private static ObjectInputStream in;
    private static ObjectOutputStream out;

    public SocketModule(int port) throws IOException {
        clientSocket = new Socket("localhost", port);
    }

    public SocketModule(Socket socket) {
        clientSocket = socket;
    }

    public SocketModule connect() throws IOException {
        out = new ObjectOutputStream(clientSocket.getOutputStream());
        out.flush();
        in = new ObjectInputStream(clientSocket.getInputStream());

        return this;
    }

    public void sendMessage(String message) throws IOException {
        out.writeObject(message);
        out.flush();
    }

    public void sendObject(Object object) throws IOException {
        out.writeObject(object);
        out.flush();
    }

    public String getMessage() throws IOException, ClassNotFoundException {
        return (String) in.readObject();
    }

    public Object getObject() throws IOException, ClassNotFoundException {
        return in.readObject();
    }

    public void close() throws IOException {
        clientSocket.close();
        in.close();
        out.close();
    }
}

package org.zero.module;

import java.io.*;
import java.net.ServerSocket;

public class ServerSocketModule {
    private static ServerSocket server;

    public ServerSocketModule(int port) throws IOException {
        server = new ServerSocket(4004);
    }

    public SocketModule getConnection() throws IOException {
        return new SocketModule(server.accept());
    }

    public void close() throws IOException {
        server.close();
    }
}

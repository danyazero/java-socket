package org.zero;

import org.zero.module.ServerSocketModule;

import java.io.*;
import java.net.Socket;

public class MainServer {
    private static ServerSocketModule server; // серверсокет

    public static void main(String[] args) throws IOException {

        server = new ServerSocketModule(4004);
        System.out.println("Сервер запущен!");
        var client = server.getConnection().connect();

        try {
            var message = client.getMessageFromServer();
            System.out.println(message);
            client.sendMessageToServer("Привет, это Сервер! Подтверждаю, ваше высказывание : " + message);
        } finally {
            client.close();
        }

        server.close();
    }
}
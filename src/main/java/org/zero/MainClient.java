package org.zero;

import org.zero.module.SocketModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClient {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static SocketModule socketModule;

    public static void main(String[] args) throws IOException {
        try {
            socketModule = new SocketModule(4004).connect();

            while (true) {
                System.out.println("Введите это здесь:");
                String word = reader.readLine();
                socketModule.sendMessageToServer(word);
                String serverWord = socketModule.getMessageFromServer();
                System.out.println(serverWord);
            }
        }finally {
            System.out.println("Клиент был закрыт...");
            socketModule.close();
        }

    }
}

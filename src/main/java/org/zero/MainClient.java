package org.zero;

import org.zero.model.FileMeta;
import org.zero.module.SocketModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClient {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static SocketModule socketModule;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            socketModule = new SocketModule(4004).connect();
            while (true) {
                System.out.println("Введите это здесь:");
                String word = reader.readLine();
                socketModule.sendMessage(word);
                FileMeta serverWord = (FileMeta) socketModule.getObject();
                System.out.println(serverWord.lastAccessTime());
            }
        }finally {
            System.out.println("Клиент был закрыт...");
            socketModule.close();
        }

    }
}

package org.zero;

import org.zero.model.FileMeta;
import org.zero.module.ServerSocketModule;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class MainServer {
    private static ServerSocketModule server; // серверсокет

    public static void main(String[] args) throws IOException {

        server = new ServerSocketModule(4004);
        System.out.println("Сервер запущен!");
        var client = server.getConnection().connect();

        while (true) {
            var message = client.getMessageFromServer();
            if (message != null) {
                System.out.println(message);
                File file = new File(message);

                if (file.exists()) {
                    var fileMeta = Files.readAttributes(Path.of(file.getPath()), BasicFileAttributes.class);

                    var data = new FileMeta(true, file.getAbsolutePath(), file.isDirectory(), file.isHidden(), fileMeta.creationTime().toString(), fileMeta.lastModifiedTime().toString(), fileMeta.lastAccessTime().toString(), fileMeta.size());

                    client.sendMessageToServer(data.toString());
                } else {
                    client.sendMessageToServer("Файл не существует: " + message);
                }
            }
        }

//        server.close();
    }
}
package org.delta.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IO {
    private IO() {}

    public static boolean write(String path, String content) {
        Path p = Paths.get(path);
        try {
            Files.write(p, content.getBytes());
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static String read(String path) {
        Path p = Paths.get(path);
        try {
            return Files.readString(p);
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean delete(String path) {
        Path p = Paths.get(path);
        try {
            Files.delete(p);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean exists(String path) {
        Path p = Paths.get(path);
        return Files.exists(p);
    }

}

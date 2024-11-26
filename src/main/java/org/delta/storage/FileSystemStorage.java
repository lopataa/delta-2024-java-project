package org.delta.storage;

public class FileSystemStorage implements Storage {
    @Override
    public boolean write(String path, String content) {
        return IO.write(path, content);
    }

    @Override
    public boolean delete(String path) {
        return IO.delete(path);
    }

    @Override
    public boolean exists(String path) {
        return IO.exists(path);
    }

    @Override
    public String read(String path) {
        return IO.read(path);
    }
}

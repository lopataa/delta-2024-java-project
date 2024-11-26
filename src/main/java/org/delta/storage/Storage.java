package org.delta.storage;

public interface Storage {
    public boolean write(String path, String content);
    public boolean delete(String path);
    public boolean exists(String path);
    public String read(String path);
}

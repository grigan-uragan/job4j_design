package cash;

import java.io.*;
import java.lang.ref.SoftReference;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class TXTFileReader implements FileVisitor<Path> {
    private Map<String, SoftReference<String>> store = new HashMap<>();

    @Override
    public FileVisitResult preVisitDirectory(
            Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(
            Path file, BasicFileAttributes attrs) throws IOException {
        if (file.getFileName().toString().endsWith("txt")) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
                StringBuilder result = new StringBuilder();
                while (reader.ready()) {
                    result.append(reader.readLine());
                }
                String key = file.getFileName().toString();

                if (!store.containsKey(key)) {
                    store.put(key, new SoftReference<String>(result.toString()));
                } else if (store.get(key).get() == null) {
                    System.out.println("file was reload");
                    store.put(key, new SoftReference<String>(result.toString()));
                }
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(
            Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(
            Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public Map<String, SoftReference<String>> getStore() {
        return store;
    }

    public void loadSingleFile(String file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append(reader.readLine());
            }
            store.put(file, new SoftReference<>(result.toString()));
            System.out.println(file + " was loaded");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

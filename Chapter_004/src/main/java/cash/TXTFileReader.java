package cash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

public class TXTFileReader implements FileVisitor<Path> {
    private Map<String, String> store = new HashMap<>();

    @Override
    public FileVisitResult preVisitDirectory(
            Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(
            Path file, BasicFileAttributes attrs) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append(reader.readLine());
            }
            store.putIfAbsent(file.getFileName().toString(), result.toString());
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

    public Map<String, String> getStore() {
        return store;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("cash cleared");
    }
}

package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwinsSearcher implements FileVisitor<Path> {
    private Set<FileProperty> uniqueFile = new HashSet<>();
    private List<Path> duplicated = new ArrayList<>();

    public void printDuplicate() {
        duplicated.forEach(System.out::println);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            FileProperty fileProperty =
                    new FileProperty(file.getFileName().toString(), file.toFile().length());
            if (uniqueFile.contains(fileProperty)) {
                duplicated.add(file);
            } else {
                uniqueFile.add(fileProperty);
            }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return FileVisitResult.CONTINUE;
    }

    public Set<FileProperty> getUniqueFile() {
        return uniqueFile;
    }

    public List<Path> getDuplicated() {
        return duplicated;
    }
}

package io;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFile implements FileVisitor<Path> {
    private Predicate<Path> predicate;
    private List<Path> pathListList = new ArrayList<>();
    private List<File> filesList = new ArrayList<>();

    public SearchFile(Predicate<Path> predicate) {
        this.predicate = predicate;
    }

    private void fileToPath() {
        filesList.forEach(file -> pathListList.add(file.toPath()));
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (predicate.test(file)) {
            filesList.add(file.toFile());
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

    public List<File> getFiles() {
        return filesList;
    }

    public List<Path> getPathListList() {
        fileToPath();
        return pathListList;
    }

    public Predicate<Path> getPredicate() {
        return predicate;
    }
}

package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Search {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        SearchFile searcher =
                new SearchFile(path -> path.toFile().getName().endsWith("txt"));
        TwinsSearcher twinsSearcher = new TwinsSearcher();
        Files.walkFileTree(start, searcher);
        Files.walkFileTree(start, twinsSearcher);

    }
}

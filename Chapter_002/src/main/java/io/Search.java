package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException(
                    "Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path start = Paths.get(args[0]);
        SearchFile searcher =
                new SearchFile(path -> path.toFile().getName().endsWith(args[1]));
        TwinsSearcher twinsSearcher = new TwinsSearcher();
        Files.walkFileTree(start, searcher);
        Files.walkFileTree(start, twinsSearcher);
        twinsSearcher.printDuplicate();
    }
}

package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class FindFileByArgs {
    //java -jar find.jar -d /Users/Admin/IdeaProjects/job4j_design -n *.txt -m -o logFile.txt
    private final ArgsName argsName;

    public FindFileByArgs(String[] args) {
        this.argsName = ArgsName.of(args);
    }

    public String getDirectory() {
        if (!argsName.containsParam("d")) {
            throw new IllegalArgumentException("Please check your direction param");
        }
       return argsName.get("d");
    }

    private String searchFileParam() {
        if (!argsName.containsParam("n")) {
            throw new IllegalArgumentException("Please check your fileName param");
        }
        return argsName.get("n");
    }

    public Predicate<Path> getCriteria() {
        String string = searchFileParam();
        if (argsName.containsParam("m")) {
            return path -> path.toString().contains(string.substring(1));
        } else if (argsName.containsParam("f")) {
            return path -> path.toString().equals(string);

        } else if (argsName.containsParam("r")) {
            Pattern pattern = Pattern.compile(string);
            return path -> pattern.matcher(path.toString()).find();
        } else {
            throw new IllegalArgumentException("Criteria not found");
        }
    }

    public List<File> files() throws IOException {
        SearchFile searchFile = new SearchFile(getCriteria());
        Files.walkFileTree(Path.of(getDirectory()), searchFile);
        return searchFile.getFiles();
    }

    public void recordResult() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(argsName.get("o")))) {
            files().forEach(file -> {
                try {
                    writer.write(file.getName() + System.lineSeparator());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        FindFileByArgs fileByArgs = new FindFileByArgs(args);
        fileByArgs.files().forEach(file -> System.out.println(
                file.getName() + " - " + file.length() + "byte."));
        fileByArgs.recordResult();
    }
}

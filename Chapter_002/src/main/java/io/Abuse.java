package io;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class Abuse {
    public static void drop(String source, String target, List<String> words) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintWriter writer = new PrintWriter(new FileWriter(target));
        reader.lines()
                .flatMap(s -> Stream.of(s.split("\\s")))
                .filter(word -> !words.contains(word))
                .map(word -> word + " ")
                .forEach(writer::print);
    }
}

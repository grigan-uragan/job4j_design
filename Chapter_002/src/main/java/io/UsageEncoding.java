package io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class UsageEncoding {
    public String readFile(String path) {
        StringBuilder string = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new FileReader(path, StandardCharsets.UTF_8))) {
            int data;
            while ((data = reader.read()) > 0) {
                string.append((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string.toString();
    }

    public void writeDataInFile(String target, String data) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(target, StandardCharsets.UTF_8, true))) {
            writer.write(data + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "/Users/Admin/IdeaProjects/job4j_design/input.txt";
        UsageEncoding usageEncoding = new UsageEncoding();
        String string = usageEncoding.readFile(path);
        usageEncoding.writeDataInFile(path, string);
        string = usageEncoding.readFile(path);
        System.out.println("Data from file: ");
        System.out.println(string);
    }
}

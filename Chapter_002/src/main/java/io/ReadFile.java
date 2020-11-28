package io;

import java.io.FileInputStream;

public class ReadFile {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("input.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        String[] strings = text.toString().split(System.lineSeparator());
        for (String str : strings) {
            System.out.println(str);
        }
    }
}

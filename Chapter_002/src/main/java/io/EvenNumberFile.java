package io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] numbers = text.toString().split(System.lineSeparator());
        for (String num : numbers) {
            int result = Integer.parseInt(num);
            if (result % 2 == 0) {
                System.out.println(result);
            }
        }
    }
}

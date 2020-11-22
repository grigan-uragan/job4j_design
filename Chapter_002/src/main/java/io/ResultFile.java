package io;

import java.io.FileOutputStream;

public class ResultFile {

    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (j == 10) {
                    String x = i * j + " \n";
                    result.append(x);
                } else {
                    String x = i * j + " ";
                    result.append(x);
                }
            }
        }
        try (FileOutputStream out = new FileOutputStream("file.txt")) {
            out.write(result.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

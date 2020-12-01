package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {

    public void unavailable(String source, String target) {
        boolean needRecord = false;
        String startRecord = "";
        String stopRecord;
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            String log;
             while (reader.ready()) {
                log  = reader.readLine();
                String[] strings = log.split("\\s");
                 if (strings[0].equals("500") || strings[0].equals("400")) {
                     if (!needRecord) {
                         needRecord = true;
                         startRecord = strings[1];
                     }
                 } else {
                     if (needRecord) {
                         stopRecord = strings[1];
                         needRecord = false;
                         writer.println(startRecord + ";" + stopRecord);
                     }
                 }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

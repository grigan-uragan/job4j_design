package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> logList = new ArrayList<>();
        boolean needRecord = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
          logList.addAll(reader.lines()
                  .filter(s -> !s.isEmpty())
                  .collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String startRecord = "";
        String stopRecord;
        List<String> report = new ArrayList<>();
        for (String str : logList) {
           String[] strings = str.split("\\s");
           if (strings[0].equals("500") || strings[0].equals("400")) {
               if (!needRecord) {
                   needRecord = true;
                  startRecord = strings[1];
               }
           } else {
               if (needRecord) {
                   stopRecord = strings[1];
                   needRecord = false;
                   report.add(startRecord + ";" + stopRecord);
               }
           }
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            report.forEach(writer::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

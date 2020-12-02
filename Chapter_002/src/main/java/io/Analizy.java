package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {

    public void unavailable(String source, String target) {
        List<String> diapason = serverWorkAnalysis(logReader(source));
        logWriter(diapason, target);
    }

    private List<String> logReader(String source) {
        List<String> logList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            while (reader.ready()) {
                logList.add(reader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logList;
    }

    private List<String> serverWorkAnalysis(List<String> logList) {
        boolean needRecord = false;
        String startRecord = "";
        String stopRecord;
        List<String> result = new ArrayList<>();
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
                    result.add(startRecord + ";" + stopRecord);
                }
            }
        }
        return result;
    }

    private void logWriter(List<String> log, String target) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(target))) {
            log.forEach(writer::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

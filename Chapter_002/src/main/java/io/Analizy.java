package io;

import java.io.*;

public class Analizy {

    private String startRecord;
    private boolean needRecord = false;

    public void unavailable(String source, String target) {
        File file = new File(target);
        file.delete();
        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
          reader.lines()
                  .filter(s -> !s.isEmpty())
                  .map(s -> s.split("\\s"))
                  .forEach(strings -> fallingStart(strings, file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void fallingStart(String[] strings, File fileName) {
        if (strings[0].equals("500") || strings[0].equals("400")) {
            if (!needRecord) {
                needRecord = true;
                startRecord = strings[1];
            }
        } else {
            if (needRecord) {
                String stopRecord = strings[1];
                needRecord = false;
                 writeFallingDownTime(startRecord
                         + ";" + stopRecord, fileName);
            }
        }
    }

    private void writeFallingDownTime(String diapozone, File fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, true))) {
            writer.println(diapozone);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

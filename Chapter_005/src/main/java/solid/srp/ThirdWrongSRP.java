package solid.srp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ThirdWrongSRP {

    public List<String> readFromKeyBoard() {
        List<String> strings = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (reader.ready()) {
                strings.add(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    public void writeIntoFile(String file, String string) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

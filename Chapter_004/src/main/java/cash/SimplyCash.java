package cash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SimplyCash {
    private String path;
    private Map<String, SoftReference<String>> cash = new HashMap<>();

    public SimplyCash(String path) {
        this.path = path;
    }

    private String read(String file) throws IOException {
        String string = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder result = new StringBuilder();
            while (reader.ready()) {
                result.append(reader.readLine());
            }
            cash.put(file, new SoftReference<>(result.toString()));
            System.out.println(file + " was loaded");
            string = cash.get(file).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public String getFileInstance(String key) throws IOException {
        String result;
        if (cash != null && cash.get(key) != null) {
            result = cash.get(key).get();
            if (result == null) {
                result = read(key);
            }
        } else {
            result = read(key);
        }
        return result;
    }

    public void getResponse() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String response = "";
            while (!"exit".equals(response)) {
                System.out.println("Whats file instance you need?\n");
                response = reader.readLine();
                if (response.equals("exit")) {
                    return;
                }
                System.out.println(this.getFileInstance(response));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        SimplyCash cash = new SimplyCash("/Users/Admin/IdeaProjects/job4j_design/");
        cash.getResponse();
    }
}

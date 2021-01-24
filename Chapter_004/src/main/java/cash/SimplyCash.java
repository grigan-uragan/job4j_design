package cash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class SimplyCash {
    private String path;
    private WeakReference<Map<String, String>> cash;
    private int count = 0;

    public SimplyCash(String path) {
        this.path = path;
    }

    private Map<String, String> read() throws IOException {
        TXTFileReader reader = new TXTFileReader();
        Files.walkFileTree(Paths.get(path), reader);
        return reader.getStore();
    }

    public String getFileInstance(String key) throws IOException {
        if (cash == null || cash.get() == null) {
            cash = new WeakReference<>(read());
            count++;
            System.out.println("Cash was reloaded in " + count + " times");
        }
        if (cash.get().containsKey(key)) {
            return cash.get().get(key);
        } else {
            throw new IllegalArgumentException("Invalid key");
        }
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

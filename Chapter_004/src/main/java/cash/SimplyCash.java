package cash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class SimplyCash {
    private String path;
    private Map<String, SoftReference<String>> cash;
    private TXTFileReader reader = new TXTFileReader();

    public SimplyCash(String path) {
        this.path = path;
    }

    private Map<String, SoftReference<String>> read() throws IOException {
        Files.walkFileTree(Paths.get(path), reader);
        return reader.getStore();
    }

    public String getFileInstance(String key) throws IOException {
        if (cash == null) {
            cash = read();
        }
        if (!cash.containsKey(key)) {
            throw new IllegalArgumentException("invalid key");
        }
        String result = cash.get(key).get();
        if (result == null) {
            reader.loadSingleFile(key);
            cash = reader.getStore();
            result = cash.get(key).get();
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

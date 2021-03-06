package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
             reader.lines()
                    .filter(s -> (!s.contains("#") && !s.contains("!")))
                    .filter(s -> s.contains("="))
                    .map(s -> s.split("="))
                    .forEach(strings -> {
                        String str = "";
                        if (strings.length > 1) {
                            str = strings[1];
                        }
                        values.put(strings[0], str);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key)  {
        String result = values.get(key);
        if (!values.containsKey(key)) {
            throw new UnsupportedOperationException("Method not found");
        }
        if (result.isEmpty()) {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
        return result;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader reader = new BufferedReader(
                new FileReader(this.path))) {
            reader.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public Map<String, String> getValues() {
        return values;
    }

}

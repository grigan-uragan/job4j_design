package io;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Unsupported params");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length != 0) {
            Stream.of(args)
                    .filter(s -> s.contains("-") && s.contains("="))
                    .map(s -> s.split("="))
                    .forEach(strings -> {
                        String key;
                        String value = "";
                        if (strings.length > 1) {
                            value = strings[1];
                        }
                        key = strings[0].substring(1);
                        values.put(key, value);
                    });
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName argsName = new ArgsName();
        argsName.parse(args);
        return argsName;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}

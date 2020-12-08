package io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Params not found");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length != 0) {
            for (String str : args) {
                if (str.contains("-") && str.contains("=")) {
                    String[] params = str.split("=");
                    if (params.length != 2) {
                        throw new IllegalArgumentException("Invalid params '=' ");
                    }
                    values.put(params[0].substring(1), params[1]);
                } else {
                    throw new IllegalArgumentException("Invalid params");
                }
            }
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

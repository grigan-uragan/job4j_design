package io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!containsParam(key)) {
            throw new IllegalArgumentException("Params not found");
        }
        return values.get(key);
    }

    public boolean containsParam(String key) {
        return values.containsKey(key);
    }

    private void parse(String[] args, String delimiter) {
        if (args.length != 0) {
            for (String str : args) {
                if (str.contains("-") && str.contains(delimiter)) {
                    String[] params = str.split("=");
                    if (params.length != 2) {
                        throw new IllegalArgumentException(
                                String.format("Invalid params %s ", delimiter));
                    }
                    values.put(params[0].substring(1), params[1]);
                }
            }
        }
    }

    private void parseWithoutDelimiter(String[] args) {
        if (args.length != 0) {
            for (int i = 0; i < args.length; i++) {
                if (args[i].startsWith("-")) {
                    if (args.length > (i + 1)) {
                        if (args[i + 1].startsWith("-")) {
                            values.put(args[i].substring(1), "");
                        } else {
                            values.put(args[i].substring(1), args[i + 1]);
                        }
                    } else {
                        values.put(args[i].substring(1), "");
                    }
                }
            }
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName argsName = new ArgsName();
        argsName.parseWithoutDelimiter(args);
        return argsName;
    }

    public static ArgsName of(String[] args, String delimiter) {
        ArgsName argsName = new ArgsName();
        argsName.parse(args, delimiter);
        return argsName;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"}, "=");
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"}, "=");
        System.out.println(zip.get("out"));

        ArgsName arg  = ArgsName.of(args);
        System.out.println(arg.get("o"));
    }
}

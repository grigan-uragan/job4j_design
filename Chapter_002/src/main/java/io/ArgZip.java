package io;

public class ArgZip {
    private final ArgsName argsName;

    //    java -jar pack.jar -d=c:\project\job4j\ -e=class -o=project.zip
    //    java -jar find.jar -d c:/ -n *.txt -m -o log.txt
    public ArgZip(String[] args) {
        if (delimiterCheck(args)) {
            argsName = ArgsName.of(args, "=");
        } else {
            argsName = ArgsName.of(args);
        }
    }

    private boolean delimiterCheck(String[] args) {
        for (String str : args) {
            if (str.contains("=")) {
                return true;
            }
        }
        return false;
    }

    public boolean isValid() {
        return argsName.containsParam("d")
                && argsName.containsParam("e")
                && argsName.containsParam("o");
    }

    public String directory() {
        return argsName.get("d");
    }

    public String exclude() {
        return argsName.get("e");
    }

    public String output() {
        return argsName.get("o");
    }

}

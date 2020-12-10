package io;

public class ArgZip {
    private final ArgsName argsName;

    //    java -jar pack.jar -d=c:\project\job4j\ -e=class -o=project.zip

    public ArgZip(String[] args) {
        argsName = ArgsName.of(args);
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

package io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ConsoleChat {

    private static final Logger LOG = LoggerFactory.getLogger(ConsoleChat.class.getName());
    private static final String STOP = "стоп";
    private static final String OUT = "закончить";
    private static final String CONTINUE = "продолжить";
    private String path;
    private String botAnswer;
    private boolean needAnswer = true;
    private List<String> answers = new ArrayList<>();
    private List<String> log = new ArrayList<>();

    public ConsoleChat(String path, String botAnswerPath) {
        this.path = path;
        this.botAnswer = botAnswerPath;
    }

    public void run() {
        String input = "";
        String output;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!input.equals(ConsoleChat.OUT)) {
                System.out.print("user: ");
                input = reader.readLine();
                log.add("user: " + input + System.lineSeparator());
                output = answer(input);
                if (!output.isEmpty()) {
                    log.add(output + System.lineSeparator());
                    System.out.println(output);
                }
            }
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(path, StandardCharsets.UTF_8))) {
                log.forEach(s -> {
                    try {
                        writer.write(s);
                    } catch (IOException e) {
                        LOG.error("Some problems with BufferedWriter", e);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String answer(String message) {
        String result = "";
        if (answers.isEmpty()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(botAnswer))) {
                while (reader.ready()) {
                    answers.add(reader.readLine());
                }
            } catch (IOException e) {
                LOG.error("Some problems with BufferedReader", e);
            }
        }
        if (message.equals(ConsoleChat.STOP) || message.equals(ConsoleChat.OUT)) {
            needAnswer = false;
            return "";
        }
        if (message.equals(ConsoleChat.CONTINUE)) {
            needAnswer = true;
            return "Продолжаем разговор";
        }
        if (needAnswer) {
            int index = (int) (Math.random() * answers.size());
            result = answers.get(index);
        }
        return "bot: " + result;
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat(
                "/Users/Admin/IdeaProjects/job4j_design/input.txt",
                "/Users/Admin/IdeaProjects/job4j_design/answers.txt");
        consoleChat.run();
    }
}

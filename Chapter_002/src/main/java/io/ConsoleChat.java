package io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class ConsoleChat {

    private static final String STOP = "стоп";
    private static final String OUT = "закончить";
    private static final String CONTINUE = "продолжить";
    private String path;
    private String botAnswer;
    private boolean needAnswer = true;

    public ConsoleChat(String path, String botAnswer) {
        this.path = path;
        this.botAnswer = botAnswer;
    }

    public void run() {
        String input = "";
        String output;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(path, StandardCharsets.UTF_8, true))) {
            while (!input.equals(ConsoleChat.OUT)) {
                System.out.print("user: ");
                input = reader.readLine();
                writer.write("user: " + input + System.lineSeparator());
                writer.flush();
                output = answer(input);
                if (!output.isEmpty()) {
                    writer.write(output + System.lineSeparator());
                    writer.flush();
                    System.out.println(output);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String answer(String message) {
        String result = "";
        String[] answers = botAnswer.split(System.lineSeparator());
        if (message.equals(ConsoleChat.STOP) || message.equals(ConsoleChat.OUT)) {
            needAnswer = false;
            return "";
        }
        if (message.equals(ConsoleChat.CONTINUE)) {
            needAnswer = true;
            return "Продолжаем разговор";
        }
        if (needAnswer) {
            int index = (int) (Math.random() * answers.length);
            result = answers[index];
        }
        return "bot: " + result;
    }

    public static void main(String[] args) {
        String answer = "Привет \n"
                + "Как дела?\n"
                + "А ты как думаешь?\n"
                + "Ой всё...\n"
                + "Как интересно\n"
                + "Нормально";
        ConsoleChat consoleChat = new ConsoleChat(
                "/Users/Admin/IdeaProjects/job4j_design/input.txt", answer);
        consoleChat.run();
    }

}

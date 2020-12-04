package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import javax.lang.model.util.ElementScanner6;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenServerDoNotFailedThenReportEmpty() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        List<String> result;
        try (PrintWriter writer = new PrintWriter(new FileWriter(source))) {
            writer.println("200 10:56:01");
            writer.println("300 10:57:01");
            writer.println("300 10:58:01");
            writer.println("200 10:59:01");
            writer.println("200 11:01:02");
            writer.println("300 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            result = reader.lines().collect(Collectors.toList());
        }
        assertThat(result.toString(), is("[]"));
    }

    @Test
    public void whenServerFallingTwiceThenTwoLinesInReport() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        List<String> result = new ArrayList<>();
        try (PrintWriter writer = new PrintWriter(new FileWriter(source))) {
            writer.println("200 10:56:01");
            writer.println("500 10:57:01");
            writer.println("400 10:58:01");
            writer.println("200 10:59:01");
            writer.println("500 11:01:02");
            writer.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            result = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
          assertThat(result.toString(), is("[10:57:01;10:59:01, 11:01:02;11:02:02]"));
    }

    @Test
    public void whenServerAllTimeFalling() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        List<String> result;
        try (PrintWriter writer = new PrintWriter(new FileWriter(source))) {
            writer.println("400 10:56:01");
            writer.println("500 10:57:01");
            writer.println("500 10:58:01");
            writer.println("500 10:59:01");
            writer.println("400 11:01:02");
            writer.println("400 11:02:02");
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            result = reader.lines().collect(Collectors.toList());
        }
        assertThat(result.toString(), is("[10:56:01; until now ]"));
    }
}
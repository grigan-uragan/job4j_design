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
    public void whenServerDoNotFailedThenReportEmpty() {
        Analizy analizy = new Analizy();
        analizy.unavailable("/Users/Admin/IdeaProjects/job4j_design/ServerGoodWork.txt",
                "/Users/Admin/IdeaProjects/job4j_design/unavailable.csv");
        File file = new File(
                "report.txt");
        long result = file.length();
        assertThat(result, is(0L));
    }

    @Test
    public void whenServerFallingTwiceThenTwoLinesInReport() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        Analizy analizy = new Analizy();
        List<String> result = new ArrayList<>();
        try (PrintWriter writer = new PrintWriter(new FileWriter(source))) {
            writer.println("200 10:56:01\n"
                    + "500 10:57:01\n"
                    + "400 10:58:01\n"
                    + "200 10:59:01\n"
                    + "500 11:01:02\n"
                    + "200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            result = reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
          assertThat(result.size(), is(2));
    }
}
package io;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

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
    public void whenServerFallingTwiceThenTwoLinesInReport() {
          Analizy analizy = new Analizy();
          analizy.unavailable("/Users/Admin/IdeaProjects/job4j_design/ServerFailedLog.txt",
                  "report.csv");
          BufferedReadFile file = new BufferedReadFile();
          List<String> result = file.readLogFile("report.csv");
          assertThat(result.size(), is(2));
    }
}
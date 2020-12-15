package io;

import org.junit.Test;

import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class BufferedReadFileTest {

    @Test
    public void whenFileHave3LinesThenListGive3Size() {
        BufferedReadFile readFile = new BufferedReadFile();
        List<String> result = readFile
                .readLogFile("/Users/Admin/IdeaProjects/job4j_design/ServerFailedLog.txt");
        assertThat(result.size(), is(6));
    }
}
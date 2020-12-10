package io;

import org.junit.Test;

import java.nio.file.Path;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SearchFileTest {

    @Test
    public void whenClassIgnore() {
        SearchFile searchFile = new SearchFile(path -> !path.toString().endsWith("class"));
        Path test = Path.of(
                "/Users/Admin/IdeaProjects/job4j_design"
                        + "/Chapter_002/target/classes/io/Analizy.class");
        boolean result = searchFile.getPredicate().test(test);

        assertThat(result, is(false));
    }
}
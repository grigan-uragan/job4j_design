package io;

import org.junit.Test;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FindFileByArgsTest {

    @Test
    public void whenArgsCorrectThenDirectoryCorrect() {
        String[] args = new String[]{
                "java", "-jar", "find.jar", "-d", "c:/", "-n", "*.txt", "-m", "-o", "log.txt"};
        FindFileByArgs fileByArgs = new FindFileByArgs(args);
        assertThat(fileByArgs.getDirectory(), is("c:/"));
    }

    @Test
    public void whenArgsMaskCorrectThenStrategyCorrect() {
        String[] args = new String[]{
                "java", "-jar", "find.jar", "-d", "c:/", "-n", "*.txt", "-m", "-o", "log.txt"};
        FindFileByArgs fileByArgs = new FindFileByArgs(args);
        Predicate<Path> predicate = fileByArgs.getCriteria();
        assertThat(fileByArgs.getCriteria().test(Path.of("test.txt")), is(true));
    }

    @Test
    public void whenArgsRegexCorrectThenStrategyCorrect() {
        String[] args = new String[]{
                "java", "-jar", "find.jar", "-d", "c:/", "-n", ".txt$", "-r", "-o", "log.txt"};
        FindFileByArgs fileByArgs = new FindFileByArgs(args);
        Predicate<Path> predicate = fileByArgs.getCriteria();
        assertThat(fileByArgs.getCriteria().test(Path.of("test.txt")), is(true));
    }

    @Test
    public void whenArgsFullNameCorrectThenStrategyCorrect() {
        String[] args = new String[]{
                "java", "-jar", "find.jar", "-d", "c:/", "-n", "test.txt", "-f", "-o", "log.txt"};
        FindFileByArgs fileByArgs = new FindFileByArgs(args);
        Predicate<Path> predicate = fileByArgs.getCriteria();
        assertThat(fileByArgs.getCriteria().test(Path.of("test.txt")), is(true));
    }

}
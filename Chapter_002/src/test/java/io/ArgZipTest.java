package io;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ArgZipTest {

    @Test
    public void whenArgsCorrectThenArgZipIsValid() {
        ArgZip argZip = new ArgZip(
                new String[]{"java -jar", "pack.jar",
                        "-d=c:\\project\\job4j\\", "-e=class", "-o=project.zip"});
        assertThat(argZip.isValid(), is(true));
    }

    @Test
    public void whenArgsCorrectThenExcludeReturnClass() {
        ArgZip argZip = new ArgZip(
                new String[]{"java -jar", "pack.jar",
                        "-d=c:\\project\\job4j\\", "-e=class", "-o=project.zip"});
        assertThat(argZip.exclude(), is("class"));
    }

    @Test
    public void whenArgsCorrectThenDirectoryReturnJob4j() {
        ArgZip argZip = new ArgZip(
                new String[]{"java -jar", "pack.jar",
                        "-d=c:\\project\\job4j\\", "-e=class", "-o=project.zip"});
        assertThat(argZip.directory(), is("c:\\project\\job4j\\"));
    }
}
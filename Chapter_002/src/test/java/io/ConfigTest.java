package io;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ConfigTest {

    @Test
    public void whenConfigWithoutCommentsThenAllPropertyPutToMap() {
        String path =
                "../propertiesForTest/withoutComments.properties";
        Config config = new Config(path);
        config.load();
        String result = config.value("name");
        assertThat(result, is("Grigory"));
    }

    @Test
    public void whenConfigWithCommentsThenCommentsDoNotInsertToMapKey() {
        String path =
                "../propertiesForTest/withComments.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.getValues().size(), is(3));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenParamIsEmptyThemThrowUnsupportedException() {
        String path =
                "../propertiesForTest/withComments.properties";
        Config config = new Config(path);
        config.load();
        config.value("surname");
    }

}
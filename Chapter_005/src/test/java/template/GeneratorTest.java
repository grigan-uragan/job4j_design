package template;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {
    String string = "I am a ${name}, Who are ${subject}?";
    Map<String, String> args = new HashMap<>();

    @Test
    public void shouldReturnStringCorrect() {
        args.put("name", "Bob");
        args.put("subject", "you");
        Generator generator = new Generator() {
            @Override
            public String produce(String template, Map<String, String> args) {
                return "I am a Bob, Who are you?";
            }
        };
        String result = generator.produce(string, args);
        String expected = "I am a Bob, Who are you?";
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArgsWasMore() {
        Generator generator = new Generator() {
            @Override
            public String produce(String template, Map<String, String> args) {
                throw new IllegalArgumentException("There were more arguments");
            }
        };
        String result = generator.produce(string, args);
        String expected = "I am a Bob, Who are you?";
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfArgsFew() {
        Generator generator = new Generator() {
            @Override
            public String produce(String template, Map<String, String> args) {
                throw new IllegalArgumentException("There were fewer arguments");
            }
        };
        String result = generator.produce(string, args);
        String expected = "I am a Bob, Who are you?";
        assertThat(result, is(expected));
    }

}
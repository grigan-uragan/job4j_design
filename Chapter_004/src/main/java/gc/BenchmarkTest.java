package gc;

import org.openjdk.jmh.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Warmup(iterations = 1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BenchmarkTest {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    public boolean pr() {
        return generateBy(
                "Мой дядя самых честных правил, "
                        + "Когда не в шутку занемог, "
                        + "Он уважать себя заставил "
                        + "И лучше выдумать не мог. "
                        + "Его пример другим наука; "
                        + "Но, боже мой, какая скука "
                        + "С больным сидеть и день и ночь, "
                        + "Не отходя ни шагу прочь! "
                        + "Какое низкое коварство "
                        + "Полуживого забавлять, "
                        + "Ему подушки поправлять, "
                        + "Печально подносить лекарство, "
                        + "Вздыхать и думать про себя: "
                        + "Когда же черт возьмет тебя!",
                "Мой дядя мог думать про тебя и день и ночь"
        );
    }

    public boolean generateBy(String origin, String line) {
        List<String> stringPool = new ArrayList<>();
        origin = origin.replaceAll("[-.?!)(,:;]", " ");
        Stream.of(origin.split("\\s"))
                .map(String::toLowerCase)
                .forEach(stringPool::add);
        for (String string : line.split("\\s")) {
            if (!stringPool.contains(string.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}

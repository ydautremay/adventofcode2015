package dyve.aoc2020.day.day2;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(2);
    }

    @Override
    protected Object execute(InputReader reader) {
        return reader.stream().mapToInt(s -> {
            int[] dims = Arrays.stream(s.split("x")).mapToInt(Integer::parseInt).toArray();
            int perim = Arrays.stream(dims).sorted().limit(dims.length - 1).reduce(Integer::sum).orElse(0) * 2;
            int volume = Arrays.stream(dims).reduce((i, j) -> i * j).orElse(0);
            int ribbon = perim + volume;
            return ribbon;
        }).reduce(Integer::sum).orElse(0);
    }

}

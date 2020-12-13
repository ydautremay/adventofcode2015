package dyve.aoc2020.day.day2;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(2);
    }

    @Override
    protected Object execute(InputReader reader) {
        return reader.stream().flatMapToInt(s -> {
            int[] dims = Arrays.stream(s.split("x")).mapToInt(Integer::parseInt).toArray();
            int side1 = dims[0] * dims[1];
            int side2 = dims[0] * dims[2];
            int side3 = dims[1] * dims[2];
            return IntStream.of(2*side1, 2*side2, 2*side3, Integer.min(side1, Integer.min(side2, side3)));
        }).reduce(Integer::sum).orElse(0);
    }

}

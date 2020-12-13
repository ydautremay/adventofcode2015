package dyve.aoc2020.day.day1;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(1);
    }

    @Override
    protected Object execute(InputReader reader) {
        String input = reader.stream().findFirst().get();

        int floor = 0;
        floor += input.chars().filter(c -> c == '(').count();
        floor -= input.chars().filter(c -> c == ')').count();

        return floor;
    }

}

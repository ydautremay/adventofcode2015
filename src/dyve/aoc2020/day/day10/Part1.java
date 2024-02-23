package dyve.aoc2020.day.day10;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(10);
    }

    @Override
    protected Object execute(InputReader reader) {
        String input = reader.stream().findFirst().orElseThrow();
        for(int i = 0; i < 40; i++){
            input = LookAndSay.play(input);
        }
        return input.length();
    }

}

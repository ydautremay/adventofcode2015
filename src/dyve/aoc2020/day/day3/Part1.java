package dyve.aoc2020.day.day3;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(3);
    }

    @Override
    protected Object execute(InputReader reader) {
        Grid<Integer> houses = new Grid<>();
        int i = 0, j = 0;
        houses.set(1, 0, 0); //Present at first house
        String line = reader.stream().findFirst().orElse("");
        for(char c : line.toCharArray()){
            switch (c){
                case '^' -> j++;
                case 'v' -> j--;
                case '<' -> i--;
                case '>' -> i++;
            }
            houses.set(houses.getOrDefault(i, j, 0) + 1, i, j);
        }
        return houses.count();
    }

}

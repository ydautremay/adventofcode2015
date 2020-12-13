package dyve.aoc2020.day.day3;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(3);
    }

    @Override
    protected Object execute(InputReader reader) {
        Grid<Integer> houses = new Grid<>();
        Position santa = new Position();
        Position robo = new Position();
        houses.set(1, 0, 0); //Present at first house
        String line = reader.stream().findFirst().orElse("");
        for(int i = 0; i < line.length() - 1; i++){
            movePosition(line.charAt(i), santa);
            houses.set(houses.getOrDefault(santa.x, santa.y, 0) + 1, santa.x, santa.y);
            i++;
            movePosition(line.charAt(i), robo);
            houses.set(houses.getOrDefault(robo.x, robo.y, 0) + 1, robo.x, robo.y);
        }
        return houses.count();
    }

    private void movePosition(char c, Position p){
        switch (c){
            case '^' -> p.y++;
            case 'v' -> p.y--;
            case '<' -> p.x--;
            case '>' -> p.x++;
        }
    }

}

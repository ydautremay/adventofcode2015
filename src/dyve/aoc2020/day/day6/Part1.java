package dyve.aoc2020.day.day6;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

public class Part1 extends Part {

    Grid<Lamp> grid;

    public static void main(String[] args) throws Exception {
        new Part1().subMain(6);
    }

    @Override
    protected Object execute(InputReader reader) {
        grid = new Grid<>();
        reader.stream().forEach(this::switchLights);
        return grid.count(l -> l.on);
    }

    private void switchLights(String s) {
        String[] ops = s.split(" ");
        String[] f;
        String[] t;
        Command command;
        if(ops[0].equals("turn")){
            if(ops[1].equals("on")){
                command = Command.TURN_ON;
            }else{
                command = Command.TURN_OFF;
            }
            f = ops[2].split(",");
            t = ops[4].split(",");
        }else{
            command = Command.TOGGLE;
            f = ops[1].split(",");
            t = ops[3].split(",");
        }
        Position from = new Position(Integer.parseInt(f[0]), Integer.parseInt(f[1]));
        Position to = new Position(Integer.parseInt(t[0]), Integer.parseInt(t[1]));

        for(int i = from.x; i <= to.x; i++){
            for (int j = from.y; j <= to.y; j++){
                command.apply(grid.computeIfAbsent(i, j, Lamp::new));
            }
        }
    }

}

package dyve.aoc2020.day.day7;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part1 extends Part {

    static Pattern andPattern = Pattern.compile("(\\w+) AND (\\w+) -> (\\D+)");
    static Pattern orPattern = Pattern.compile("(\\w+) OR (\\w+) -> (\\D+)");
    static Pattern lShiftPattern = Pattern.compile("(\\w+) LSHIFT (\\d+) -> (\\D+)");
    static Pattern rShiftPattern = Pattern.compile("(\\w+) RSHIFT (\\d+) -> (\\D+)");
    static Pattern notPattern = Pattern.compile("NOT (\\w+) -> (\\D+)");
    static Pattern assignPattern = Pattern.compile("(\\w+) -> (\\D+)");

    Map<String, Wire> wires;

    public static void main(String[] args) throws Exception {
        new Part1().subMain(7);
    }

    @Override
    protected Object execute(InputReader reader) {
        List<String> lines = reader.stream().collect(Collectors.toList());
        wires = new HashMap<>();
        lines.forEach(this::doOperation);
        while(!wires.get("a").isValued()){
            lines.forEach(this::doOperation);
        }
        return (int)wires.get("a").getValue();
    }

    private void doOperation(String line){
        Matcher assignMatcher = assignPattern.matcher(line);
        Matcher andMatcher = andPattern.matcher(line);
        Matcher orMatcher = orPattern.matcher(line);
        Matcher lShiftMatcher = lShiftPattern.matcher(line);
        Matcher rShiftMatcher = rShiftPattern.matcher(line);
        Matcher notMatcher = notPattern.matcher(line);

        if(andMatcher.matches()){
            Wire input2 = wires.computeIfAbsent(andMatcher.group(2), Wire::new);
            Wire output = wires.computeIfAbsent(andMatcher.group(3), Wire::new);
            if(andMatcher.group(1).equals("1")){
                Operations.and((char)1, input2, output);
            }else{
                Wire input1 = wires.computeIfAbsent(andMatcher.group(1), Wire::new);
                Operations.and(input1, input2, output);
            }
        }else if(orMatcher.matches()){
            Wire input1 = wires.computeIfAbsent(orMatcher.group(1), Wire::new);
            Wire input2 = wires.computeIfAbsent(orMatcher.group(2), Wire::new);
            Wire output = wires.computeIfAbsent(orMatcher.group(3), Wire::new);
            Operations.or(input1, input2, output);
        }else if(rShiftMatcher.matches()){
            Wire input = wires.computeIfAbsent(rShiftMatcher.group(1), Wire::new);
            int shift = Integer.parseInt(rShiftMatcher.group(2));
            Wire output = wires.computeIfAbsent(rShiftMatcher.group(3), Wire::new);
            Operations.rShift(input, shift, output);
        }else if(lShiftMatcher.matches()){
            Wire input = wires.computeIfAbsent(lShiftMatcher.group(1), Wire::new);
            int shift = Integer.parseInt(lShiftMatcher.group(2));
            Wire output = wires.computeIfAbsent(lShiftMatcher.group(3), Wire::new);
            Operations.lShift(input, shift, output);
        }else if(notMatcher.matches()){
            Wire input = wires.computeIfAbsent(notMatcher.group(1), Wire::new);
            Wire output = wires.computeIfAbsent(notMatcher.group(2), Wire::new);
            Operations.not(input, output);
        }else if(assignMatcher.matches()){
            Wire output = wires.computeIfAbsent(assignMatcher.group(2), Wire::new);
            if(assignMatcher.group(1).matches("\\d+")){
                Operations.assign((char) Integer.parseInt(assignMatcher.group(1)), output);
            }else{
                Wire input = wires.computeIfAbsent(assignMatcher.group(1), Wire::new);
                Operations.assign(input, output);
            }
        }else{
            throw new IllegalStateException("No pattern matched !! " + line);
        }
    }

}

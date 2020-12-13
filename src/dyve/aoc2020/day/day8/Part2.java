package dyve.aoc2020.day.day8;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(8);
    }

    List<String> strings;

    @Override
    protected Object execute(InputReader reader) {
        strings = reader.stream().collect(Collectors.toList());
        int size = strings.stream().map(String::trim).mapToInt(String::length).sum();
        List<String> memory = new ArrayList<>(strings.size());
        int mem = size;
        System.out.println(mem);
        for(String s : strings){
            mem += 2;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '"' || c == '\\') {
                    mem += 1;
                }
            }
        }
        return mem - size;
    }

}

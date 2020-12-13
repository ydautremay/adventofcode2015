package dyve.aoc2020.day.day8;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(8);
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
            mem -= 2; //surrounding quotes
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c != '\\'){
                    continue;
                }
                if(s.charAt(i + 1) == '\\' || s.charAt(i + 1) == '"'){
                    mem--;
                    i++;
                }else if(s.charAt(i + 1) == 'x'){
                    mem -= 3;
                    i += 3;
                }
            }
        }
        return size - mem;
    }

}

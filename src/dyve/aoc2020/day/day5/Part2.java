package dyve.aoc2020.day.day5;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.util.regex.Pattern;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(5);
    }

    @Override
    protected Object execute(InputReader reader) throws Exception {
        return reader.stream().parallel().filter(this::isNice).count();
    }

    private boolean isNice(String s) {
        return hasPairTwice(s) && sameLetter(s);
    }

    private boolean hasPairTwice(String s) {
        boolean hasPairTwice = false;
        for(int i = 0; i < s.length() - 1; i++){
            String sub = s.substring(i, i+2);
            if(s.lastIndexOf(sub) > i + 1){
                hasPairTwice = true;
                break;
            }
        }
        return hasPairTwice;
    }
    private boolean sameLetter(String s) {
        for(int i = 0; i < s.length() - 2; i++){
            if(s.charAt(i) == s.charAt(i + 2)){
                return true;
            }
        }
        return false;
    }
}

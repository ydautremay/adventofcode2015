package dyve.aoc2020.day.day1;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(1);
    }

    protected Object execute(InputReader reader) {
        String input = reader.stream().findFirst().get();

        int floor = 0;
        char[] chars = input.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '('){
                floor++;
            }else{
                floor--;
            }
            if(floor == -1){
                return i + 1;
            }
        }
        return null;
    }
}

package dyve.aoc2020.day.day10;

public class LookAndSay {

    public static String play(String input){
        StringBuilder result = new StringBuilder();
        char current = input.charAt(0);
        int count = 1;
        for(int i = 1; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == current){
                count++;
            }else{
                result.append(count).append(current);
                current = c;
                count = 1;
            }
        }
        result.append(count).append(current);
        return result.toString();
    }
}

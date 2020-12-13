package dyve.aoc2020.day.day5;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.security.MessageDigest;
import java.util.regex.Pattern;

public class Part1 extends Part {

    Pattern vowels = Pattern.compile("(\\w*[aeuio]\\w*){3,}");

    Pattern doubleLetter = Pattern.compile("(.)\\1");

    Pattern badGroups = Pattern.compile("(xy)+|(ab)+|(cd)+|(pq)+");

    public static void main(String[] args) throws Exception {
        new Part1().subMain(5);
    }

    @Override
    protected Object execute(InputReader reader) throws Exception {
        return reader.stream().parallel().filter(this::isNice).count();
    }

    private boolean isNice(String s) {
        return vowels.matcher(s).find() && doubleLetter.matcher(s).find() && !badGroups.matcher(s).find();
    }
}

package dyve.aoc2020.day.day4;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Part1 extends Part {

    public static void main(String[] args) throws Exception {
        new Part1().subMain(4);
    }

    @Override
    protected Object execute(InputReader reader) throws Exception {
        String secret = reader.stream().findFirst().orElse("");
        String hash = "";
        int suffix = 0;
        while(!hash.startsWith("00000")){
            suffix++;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update((secret + suffix).getBytes());
            byte[] digest = md.digest();
            hash = encodeHexString(digest);
            System.out.println(hash);
        }
        return suffix;
    }

    public String encodeHexString(byte[] byteArray) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            hexStringBuffer.append(byteToHex(byteArray[i]));
        }
        return hexStringBuffer.toString();
    }

    public String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }
}

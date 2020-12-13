package dyve.aoc2020.day.day4;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;

public class Part2 extends Part {

    public static void main(String[] args) throws Exception {
        new Part2().subMain(4);
    }

    @Override
    protected Object execute(InputReader reader) throws Exception {
        String secret = reader.stream().findFirst().orElse("");
        String hash = "";
        return IntStream.iterate(0, i -> !hash(secret + i).startsWith("000000"), i -> i + 1).count();
    }

    public String hash(String input){
        System.out.println(input);
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
        md.update(input.getBytes());
        byte[] digest = md.digest();
        return encodeHexString(digest);
    }

    public String encodeHexString(byte[] byteArray) {
        StringBuffer hexStringBuffer = new StringBuffer();
        for (byte b : byteArray) {
            hexStringBuffer.append(byteToHex(b));
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

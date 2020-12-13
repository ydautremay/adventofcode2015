package dyve.aoc2020.day.day7;

public class Operations {

    public static void assign(char value, Wire wire){
        wire.setValue(value);
    }

    public static void assign(Wire input, Wire output){
        if(input.isValued()){
            output.setValue(input.getValue());
        }
    }

    public static void and(char input1, Wire input2, Wire output){
        if(input2.isValued()){
            output.setValue((char)(input1 & input2.getValue()));
        }
    }

    public static void and(Wire input1, Wire input2, Wire output){
        if(input1.isValued() && input2.isValued()) {
            output.setValue((char) (input1.getValue() & input2.getValue()));
        }
    }

    public static void or(Wire input1, Wire input2, Wire output){
        if(input1.isValued() && input2.isValued()) {
            output.setValue((char) (input1.getValue() | input2.getValue()));
        }
    }

    public static void lShift(Wire input, int shift, Wire output){
        if(input.isValued()){
            output.setValue((char) (input.getValue() << shift));
        }
    }

    public static void rShift(Wire input, int shift, Wire output){
        if(input.isValued()){
            output.setValue((char) (input.getValue() >>> shift));
        }
    }

    public static void not(Wire input, Wire output){
        if(input.isValued()){
            output.setValue((char) ~input.getValue());
        }
    }
}

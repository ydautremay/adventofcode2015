package dyve.aoc2020.day.day7;

public class Wire {

    String id;

    private char value;

    boolean valued = false;

    public Wire(String id) {
        this.id = id;
    }

    public Wire(String id, char value) {
        this.id = id;
        this.value = value;
    }

    public char getValue(){
        return value;
    }

    public void setValue(char value) {
        valued = true;
        this.value = value;
    }

    public boolean isValued(){
        return valued;
    }

    public String toString(){
        return id + " -> " + (int) value;
    }
}

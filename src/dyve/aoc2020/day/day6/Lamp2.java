package dyve.aoc2020.day.day6;

public class Lamp2 {

    int brightness = 0;

    public void turnOn(){
        brightness++;
    }

    public void turnOff(){
        brightness = Integer.max(brightness - 1, 0);
    }

    public void toggle(){
        brightness += 2;
    }

    public String toString(){
        return "X";
    }
}

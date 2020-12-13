package dyve.aoc2020.day.day6;

public enum Command {

    TURN_ON{
        @Override
        public void apply(Lamp l) {
            l.on = true;
        }
    },
    TURN_OFF{
        @Override
        public void apply(Lamp l) {
            l.on = false;
        }
    },
    TOGGLE {
        @Override
        public void apply(Lamp l) {
            l.on = !l.on;
        }
    };

    public abstract void apply(Lamp l);

}

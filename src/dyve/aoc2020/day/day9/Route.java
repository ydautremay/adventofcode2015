package dyve.aoc2020.day.day9;

import java.util.Objects;

public class Route {

    private final Location from;

    private final Location to;

    private final int distance;


    public Route(Location from, Location location, int distance) {
        this.from = from;
        to = location;
        this.distance = distance;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public int getDistance() {
        return distance;
    }

    public Route reverse(){
        return new Route(to, from, distance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return Objects.equals(from, route.from) && Objects.equals(to, route.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString(){
        return from.getName() + " -> " + to.getName() + " = " + distance;
    }
}

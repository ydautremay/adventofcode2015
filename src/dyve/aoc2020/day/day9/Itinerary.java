package dyve.aoc2020.day.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Itinerary {

    private List<Route> routes = new ArrayList<>();

    public void addRoute(Route route){
        if(!routes.isEmpty()){
            if(!route.getFrom().equals(routes.getLast().getTo())){
                throw new IllegalArgumentException("In an itinerary, last destination should match next start");
            }
        }
        routes.add(route);
    }

    public Location getDestination(){
        return routes.getLast().getTo();
    }

    public int length(){
        return routes.stream().mapToInt(Route::getDistance).sum();
    }

    public int nbLocations(){
        return routes.size() + 1;
    }

    public Itinerary copy(){
        Itinerary copy = new Itinerary();
        copy.routes = new ArrayList<>(this.routes);
        return copy;
    }

    @Override
    public String toString(){
        return routes.getFirst().getFrom().getName() + " -> " + routes.stream().map(r -> r.getTo().getName()).collect(Collectors.joining(" -> ")) + " = " + length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itinerary itinerary = (Itinerary) o;
        return Objects.equals(routes, itinerary.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routes);
    }
}

package dyve.aoc2020.day.day9;

import dyve.aoc2020.day.Part;
import dyve.aoc2020.input.InputReader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Part2 extends Part {

    private final static Pattern linePattern = Pattern.compile("(\\w+) to (\\w+) = (\\d+)");

    public static void main(String[] args) throws Exception {
        new Part2().subMain(9);
    }

    @Override
    protected Object execute(InputReader reader) {
        Map<String, Location> locations = new HashMap<>();
        Set<Route> routes = new HashSet<>();
        reader.stream().forEach(line -> {
            Matcher m = linePattern.matcher(line);
            if(!m.find()){
                throw new IllegalArgumentException("Line does not match pattern : " + line);
            }
            Location from = locations.computeIfAbsent(m.group(1), Location::new);
            Location to = locations.computeIfAbsent(m.group(2), Location::new);
            Route route = new Route(from, to, Integer.parseInt(m.group(3)));
            Route reverse = route.reverse();
            routes.add(route);
            routes.add(reverse);
        });
        Set<Itinerary> itineraries = new HashSet<>();
        for(Route start : routes){
            Itinerary itinerary = new Itinerary();
            itinerary.addRoute(start);
            itineraries.addAll(buildItineraries(itinerary, routes.stream().filter(r -> !r.getTo().equals(start.getFrom())).collect(Collectors.toSet())));
        }
        return itineraries.stream().filter(i -> i.nbLocations() == locations.size()).mapToInt(Itinerary::length).max().orElseThrow();
    }

    private Set<Itinerary> buildItineraries(Itinerary itinerary, Set<Route> routes){
        Set<Route> possibleContinuations = routes.stream().filter(r -> r.getFrom().equals(itinerary.getDestination())).collect(Collectors.toSet());
        if(possibleContinuations.isEmpty()){
            return new HashSet<>(Set.of(itinerary));
        }
        Set<Itinerary> currentItineraries = new HashSet<>();
        for(Route route : possibleContinuations){
            Itinerary newItinerary = itinerary.copy();
            newItinerary.addRoute(route);
            currentItineraries.addAll(buildItineraries(newItinerary, routes.stream().filter(r -> !r.getTo().equals(route.getFrom())).collect(Collectors.toSet())));
        }
        return currentItineraries;
    }
}

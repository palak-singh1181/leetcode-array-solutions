
import java.util.*;

public class ReconstructItinerary {

    static Map<String, PriorityQueue<String>> graph = new HashMap<>();
    static List<String> result = new ArrayList<>();

    static List<String> findItinerary(List<List<String>> tickets) {

        graph.clear();
        result.clear();

        // Build graph
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        // Start from JFK
        dfs("JFK");

        // Reverse the result
        Collections.reverse(result);

        return result;
    }

    static void dfs(String airport) {

        PriorityQueue<String> destinations = graph.get(airport);

        while (destinations != null && !destinations.isEmpty()) {

            String nextAirport = destinations.poll();

            dfs(nextAirport);
        }

        result.add(airport);
    }

    public static void main(String[] args) {

        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));

        List<String> itinerary = findItinerary(tickets);

        System.out.println("Itinerary: " + itinerary);
    }
}
package Topological_Traversal.P332_Reconstruct_Itinerary;

import java.util.*;

public class Solution {
    // Time: O(V + E)
    // Space: O(V + E)
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = buildGraph(tickets);
        List<String> res = new ArrayList<>();
        dfs(map, res, "JFK");
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> map, List<String> res, String departure) {
        PriorityQueue<String> destinations = map.get(departure);
        while (destinations != null && !destinations.isEmpty()) {
            dfs(map, res, destinations.poll());
        }

        res.add(0, departure);
    }

    private Map<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> route : tickets) {
            map.putIfAbsent(route.get(0), new PriorityQueue<>());
            map.get(route.get(0)).offer(route.get(1));
        }

        return map;
    }
}

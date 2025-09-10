class Solution {
    Map<String, PriorityQueue<String>> graph = new HashMap<>();
    LinkedList<String> itinerary = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        
        for (List<String> ticket : tickets) 
            graph.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).offer(ticket.get(1));
        
        dfs("JFK");
        return itinerary;
    }

    private void dfs(String airport) {

        PriorityQueue<String> pq = graph.get(airport);
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            dfs(next);
        }
        
        itinerary.addFirst(airport); 
    }
}

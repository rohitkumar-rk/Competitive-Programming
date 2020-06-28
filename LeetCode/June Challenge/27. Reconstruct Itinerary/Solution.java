class Solution {
    
    public void  dfs(String departure, Map<String, PriorityQueue<String>> flights,
                                LinkedList<String> itinery){
        PriorityQueue<String>  arrivals = flights.get(departure);
        
        while(arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.remove(), flights, itinery);
        itinery.addFirst(departure);
        
    }
    
    
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> itinery = new LinkedList<>();
        
        for(List<String> ticket : tickets){
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        
        dfs("JFK", flights, itinery);
        return itinery;
    }
}
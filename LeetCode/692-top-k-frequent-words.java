class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) 
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);

        PriorityQueue<String> heap = new PriorityQueue<>(
            (a, b) -> freqMap.get(a).equals(freqMap.get(b))
                ? b.compareTo(a) 
                : freqMap.get(a) - freqMap.get(b) 
        );

        for (String word : freqMap.keySet()) {
            heap.offer(word);
            
            if (heap.size() > k) 
                heap.poll(); 
        }

        List<String> result = new LinkedList<>();
        while (!heap.isEmpty()) 
            result.add(0, heap.poll()); 
        
        return result;
    }
}

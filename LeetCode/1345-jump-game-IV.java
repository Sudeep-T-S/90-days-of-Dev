class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;
        if (n == 1) 
            return 0;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) 
            graph.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        
        boolean[] visited = new boolean[n];
        visited[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int steps = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {

                int i = queue.poll();
                if (i == n - 1) 
                    return steps;
              
                if (i - 1 >= 0 && !visited[i - 1]) {
                    visited[i - 1] = true;
                    queue.offer(i - 1);
                }
                
                if (i + 1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    queue.offer(i + 1);
                }
                
                if (graph.containsKey(arr[i])) {

                    for (int j : graph.get(arr[i])) {

                        if (!visited[j]) {
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                    graph.remove(arr[i]); 
                }
            }
            steps++;
        }

        return -1;
    }
}

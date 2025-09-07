class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) 
            graph[i] = new ArrayList<>();

        for (int[] e : times) 
            graph[e[0]].add(new int[]{e[1], e[2]});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.offer(new int[]{k, 0});

        while (!heap.isEmpty()) {

            int[] curr = heap.poll();
            int node = curr[0], time = curr[1];
            if (time > dist[node]) 
                continue;

            for (int[] nei : graph[node]) {

                int next = nei[0], t = nei[1];
                if (dist[next] > dist[node] + t) {
                    dist[next] = dist[node] + t;
                    heap.offer(new int[]{next, dist[next]});
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) 
                return -1;

            max = Math.max(max, dist[i]);
        }
        
        return max;
    }
}

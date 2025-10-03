class Solution {

    public int minimumTime(int n, int[][] relations, int[] time) {

        List<Integer>[] graph = new List[n];
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) 
            graph[i] = new ArrayList<>();

        for (int[] rel : relations) {
            graph[rel[0] - 1].add(rel[1] - 1);
            indegree[rel[1] - 1]++;
        }

        int[] dp = new int[n]; 
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                dp[i] = time[i];
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {

            int cur = queue.poll();
            for (int nei : graph[cur]) {

                dp[nei] = Math.max(dp[nei], dp[cur] + time[nei]);               
                if (--indegree[nei] == 0) 
                    queue.offer(nei);
            }
        }

        int res = 0;
        for (int t : dp) 
            res = Math.max(res, t);
            
        return res;
    }
}

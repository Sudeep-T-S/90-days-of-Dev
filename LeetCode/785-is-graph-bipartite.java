class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {

            if (color[i] == 0) { 
                
                if (!dfs(graph, i, 1, color))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int c, int[] color) {

        color[node] = c;
        for (int nei : graph[node]) {

            if (color[nei] == c) 
                return false;

            if (color[nei] == 0 && !dfs(graph, nei, -c, color)) 
                return false;
        }

        return true;
    }
}

//Using Union-Find (Disjoint Set)
class Solution {

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        UnionFind uf = new UnionFind(n);
        for(int[] e : edges) 
            uf.union(e[0], e[1]);
        
        return uf.find(source) == uf.find(destination);
    }

    class UnionFind {

        int[] parent;
        int[] rank;

        UnionFind(int size) {

            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) 
                parent[i] = i;
        }

        int find(int x) {

            if (parent[x] != x) 
                parent[x] = find(parent[x]);

            return parent[x];
        }

        void union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                
                if (rank[rootA] < rank[rootB]) 
                    parent[rootA] = rootB;
                else if (rank[rootB] < rank[rootA]) 
                    parent[rootB] = rootA;
                else {
                    parent[rootB] = rootA;
                    rank[rootA]++;
                }
            }
        }
    }
}

//Using DFS
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) 
            graph.add(new ArrayList<>());

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(List<List<Integer>> graph, int node, int dest, boolean[] visited) {

        if(node == dest) 
            return true;

        visited[node] = true;
        for(int nei : graph.get(node)) {
            if(!visited[nei] && dfs(graph, nei, dest, visited)) 
                return true;
        }
        
        return false;
    }
}

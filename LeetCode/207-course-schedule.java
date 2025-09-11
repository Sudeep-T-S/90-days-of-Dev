//Using DFS Cycle Detection
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) 
            graph.add(new ArrayList<>());

        for (int[] pre : prerequisites) 
            graph.get(pre[1]).add(pre[0]);

        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {

            if (state[i] == 0 && hasCycle(graph, state, i)) 
                return false;
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int node) {

        if (state[node] == 1) 
            return true;   
        if (state[node] == 2) 
            return false; 

        state[node] = 1;
        for (int nei : graph.get(node))
            if (hasCycle(graph, state, nei)) 
                return true;

        state[node] = 2;
        return false;
    }
}

//Using Kahn's Algorithm (BFS Topological Sort)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) 
            graph.add(new ArrayList<>());
        
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegree[i] == 0) 
                queue.offer(i);

        int finished = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finished++;
            
            for (int next : graph.get(course)) {
                
                if (--indegree[next] == 0) 
                    queue.offer(next);
            }
        }
        
        return finished == numCourses;
    }
}

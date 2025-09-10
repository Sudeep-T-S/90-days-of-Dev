class Solution {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.computeIfAbsent(a, x -> new HashMap<>()).put(b, values[i]);
            graph.computeIfAbsent(b, x -> new HashMap<>()).put(a, 1.0 / values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, visited);
        }

        return res;
    }

    private double dfs(String curr, String target, double acc, Set<String> visited) {

        if (!graph.containsKey(curr)) 
            return -1.0;
        if (curr.equals(target)) 
            return acc;

        visited.add(curr);
        Map<String, Double> neighbors = graph.get(curr);
        for (String nei : neighbors.keySet()) {

            if (!visited.contains(nei)) {
                double val = dfs(nei, target, acc * neighbors.get(nei), visited);
                if (val != -1.0) 
                    return val;
            }
        }
        
        return -1.0;
    }
}

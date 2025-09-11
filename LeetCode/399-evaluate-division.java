//Using Weighted Union-Find
class Solution {
    Map<String, String> parent = new HashMap<>();
    Map<String, Double> weight = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            union(a, b, values[i]);
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {

            String a = queries.get(i).get(0), b = queries.get(i).get(1);
            if (!parent.containsKey(a) || !parent.containsKey(b)) 
                res[i] = -1.0;
            else {

                String rootA = find(a);
                String rootB = find(b);
                if (!rootA.equals(rootB)) 
                    res[i] = -1.0;
                else 
                    res[i] = weight.get(a) / weight.get(b);
            }
        }

        return res;
    }

    private String find(String x) {

        if (!parent.get(x).equals(x)) {
            String origParent = parent.get(x);
            String root = find(origParent);
            weight.put(x, weight.get(x) * weight.get(origParent));
            parent.put(x, root);
        }

        return parent.get(x);
    }

    private void union(String a, String b, double value) {

        if (!parent.containsKey(a)) {
            parent.put(a, a);
            weight.put(a, 1.0);
        }

        if (!parent.containsKey(b)) {
            parent.put(b, b);
            weight.put(b, 1.0);
        }
        
        String rootA = find(a);
        String rootB = find(b);
        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
            weight.put(rootA, value * weight.get(b) / weight.get(a));
        }
    }
}

//Using DFS Graph Traversal
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

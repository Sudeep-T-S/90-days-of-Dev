//Using BFS
class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) 
            return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        
        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            for (Node neighbor : curr.neighbors) {

                if (!map.containsKey(neighbor)) {

                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        
        return clone;
    }
}

//Using DFS
class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null) 
            return null;
            
        Map<Node, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, Map<Node, Node> map) {
        
        if (map.containsKey(node)) 
            return map.get(node);

        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);

        for (Node neighbor : node.neighbors) 
            clone.neighbors.add(clone(neighbor, map));
        
        return clone;
    }
}

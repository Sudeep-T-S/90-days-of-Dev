class Solution {
    public Node flatten(Node head) {
        
        if (head == null)
            return head;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        Node prev = null;

        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            if (prev != null) {
                prev.next = cur;
                cur.prev = prev;
            }

            if (cur.next != null)
                stack.push(cur.next);

            if (cur.child != null) {
                stack.push(cur.child);
                cur.child = null; 
            }

            prev = cur;
        }

        head.prev = null;
        return head;
    }
}

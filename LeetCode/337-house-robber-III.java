class Solution {

    public int rob(TreeNode root) {

        Map<TreeNode, Integer> memo = new HashMap<>();

        return dfs(root, memo);
    }

    private int dfs(TreeNode node, Map<TreeNode, Integer> memo) {

        if (node == null) 
            return 0;

        if (memo.containsKey(node)) 
            return memo.get(node);

        int rob = node.val;
        if (node.left != null) 
            rob += dfs(node.left.left, memo) + dfs(node.left.right, memo);

        if (node.right != null) 
            rob += dfs(node.right.left, memo) + dfs(node.right.right, memo);

        int notRob = dfs(node.left, memo) + dfs(node.right, memo);
        int res = Math.max(rob, notRob);
        memo.put(node, res);

        return res;
    }
}

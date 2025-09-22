class Solution {

    public List<TreeNode> generateTrees(int n) {

        if (n == 0) 
            return new ArrayList<>();

        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end) {

        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        for (int root = start; root <= end; root++) {

            List<TreeNode> leftSubtrees = helper(start, root - 1);
            List<TreeNode> rightSubtrees = helper(root + 1, end);
            for (TreeNode left : leftSubtrees) {

                for (TreeNode right : rightSubtrees) {
                    TreeNode node = new TreeNode(root);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        
        return res;
    }
}

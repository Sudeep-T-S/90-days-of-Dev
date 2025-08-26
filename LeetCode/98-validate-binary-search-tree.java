class Solution {
    private Long prev = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;
        if (!inorder(node.left)) return false;
        if (node.val <= prev) return false;
        prev = (long) node.val;
        return inorder(node.right);
    }
}

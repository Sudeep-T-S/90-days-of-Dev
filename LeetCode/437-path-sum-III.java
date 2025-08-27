class Solution {
    public int pathSum(TreeNode root, int targetSum) {

        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); 

        return dfs(root, 0, targetSum, prefixSumCount);
    }
    
    private int dfs(TreeNode node, long currSum, int target, Map<Long, Integer> prefixSumCount) {

        if (node == null) 
            return 0;
            
        currSum += node.val;
        int res = prefixSumCount.getOrDefault(currSum - target, 0);
        
        prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        
        res += dfs(node.left, currSum, target, prefixSumCount);
        res += dfs(node.right, currSum, target, prefixSumCount);
        
        prefixSumCount.put(currSum, prefixSumCount.get(currSum) - 1);
        return res;
    }
}

class Solution {

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) 
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        
        int[][] dp = new int[n][n];

        return dfs(0, n - 1, prefixSum, dp);
    }

    private int dfs(int i, int j, int[] prefixSum, int[][] dp) {

        if (i == j) 
            return 0;

        if (dp[i][j] != 0) 
            return dp[i][j];

        for (int k = i; k < j; k++) {

            int leftSum = prefixSum[k + 1] - prefixSum[i];
            int rightSum = prefixSum[j + 1] - prefixSum[k + 1];
            if (leftSum < rightSum) 
                dp[i][j] = Math.max(dp[i][j], leftSum + dfs(i, k, prefixSum, dp));
            else if (leftSum > rightSum) 
                dp[i][j] = Math.max(dp[i][j], rightSum + dfs(k + 1, j, prefixSum, dp));
            else { 
                dp[i][j] = Math.max(dp[i][j], Math.max(
                    leftSum + dfs(i, k, prefixSum, dp),
                    rightSum + dfs(k + 1, j, prefixSum, dp)));
            }
        }
        
        return dp[i][j];
    }
}

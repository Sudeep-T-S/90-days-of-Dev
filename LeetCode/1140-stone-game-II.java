class Solution {

    public int stoneGameII(int[] piles) {

        int n = piles.length;
        int[] suffixSum = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) 
            suffixSum[i] = piles[i] + suffixSum[i + 1];

        Integer[][] dp = new Integer[n][n + 1];

        return helper(0, 1, piles, suffixSum, dp);
    }
    
    private int helper(int i, int M, int[] piles, int[] suffixSum, Integer[][] dp) {

        int n = piles.length;
        if (i >= n) 
            return 0;

        if (dp[i][M] != null) 
            return dp[i][M];

        if (i + 2 * M >= n) {
            dp[i][M] = suffixSum[i];
            return dp[i][M];
        }

        int minOpponent = Integer.MAX_VALUE;
        for (int x = 1; x <= 2 * M; x++) 
            minOpponent = Math.min(minOpponent, helper(i + x, Math.max(M, x), piles, suffixSum, dp));

        dp[i][M] = suffixSum[i] - minOpponent;

        return dp[i][M];
    }
}

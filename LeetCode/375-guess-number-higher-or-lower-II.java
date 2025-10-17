public class Solution {

    public int getMoneyAmount(int n) {

        int[][] dp = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {

            for (int start = 1; start <= n - len + 1; start++) {

                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE;
                for (int k = start; k <= end; k++) {
                    int cost = k + Math.max(dp[start][k - 1], dp[k + 1][end]);
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }

        return dp[1][n];
    }
}

public class Solution {

    public long maximumProfit(int[] prices, int k) {

        int n = prices.length;
        long[][][] dp = new long[n + 1][k + 1][3];
        for (int i = 0; i <= n; ++i) {

            for (int t = 0; t <= k; ++t) {

                if (i == 0 || t == 0) {
                    dp[i][t][0] = 0;
                    dp[i][t][1] = Long.MIN_VALUE / 2;
                    dp[i][t][2] = Long.MIN_VALUE / 2;
                } else {
                    dp[i][t][0] = Math.max(
                        dp[i-1][t][0],
                        Math.max(dp[i-1][t][1] + prices[i-1],
                                 dp[i-1][t][2] - prices[i-1])
                    );
                    dp[i][t][1] = Math.max(
                        dp[i-1][t][1],
                        dp[i-1][t-1][0] - prices[i-1]
                    );
                    dp[i][t][2] = Math.max(
                        dp[i-1][t][2],
                        dp[i-1][t-1][0] + prices[i-1]
                    );
                }
            }
        }

        long ans = 0;
        for (int t = 0; t <= k; ++t) 
            ans = Math.max(ans, dp[n][t][0]);
        
        return ans;
    }
}

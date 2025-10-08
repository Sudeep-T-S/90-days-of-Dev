class Solution {

    private static final int MOD = 1_000_000_007;

    public int checkRecord(int n) {
        
        int[][][] dp = new int[n + 1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {

            for (int a = 0; a <= 1; a++) {

                for (int l = 0; l <= 2; l++) {
                    
                    dp[i][a][0] = (dp[i][a][0] + dp[i - 1][a][l]) % MOD;
                    if (a < 1) 
                        dp[i][a + 1][0] = (dp[i][a + 1][0] + dp[i - 1][a][l]) % MOD;
                    
                    if (l < 2) 
                        dp[i][a][l + 1] = (dp[i][a][l + 1] + dp[i - 1][a][l]) % MOD;
                }
            }
        }

        int ans = 0;
        for (int a = 0; a <= 1; a++) {

            for (int l = 0; l <= 2; l++) 
                ans = (ans + dp[n][a][l]) % MOD;
        }

        return ans;
    }
}

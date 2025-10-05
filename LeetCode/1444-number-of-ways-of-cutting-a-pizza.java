class Solution {

    private static final int MOD = 1_000_000_007;
    
    public int ways(String[] pizza, int k) {

        int m = pizza.length, n = pizza[0].length();
        int[][] apples = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {

            for (int j = n - 1; j >= 0; j--) 
                apples[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0)
                    + apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1];
        }
        Integer[][][] dp = new Integer[m][n][k + 1];

        return dfs(0, 0, k, apples, dp);
    }
    
    private int dfs(int i, int j, int cuts, int[][] apples, Integer[][][] dp) {

        if (apples[i][j] == 0) 
            return 0;

        if (cuts == 1) 
            return 1;

        if (dp[i][j][cuts] != null) 
            return dp[i][j][cuts];

        int result = 0, m = apples.length - 1, n = apples[0].length - 1;
        for (int nr = i + 1; nr < m; nr++) {

            if (apples[i][j] - apples[nr][j] > 0)
                result = (result + dfs(nr, j, cuts - 1, apples, dp)) % MOD;
        }

        for (int nc = j + 1; nc < n; nc++) {

            if (apples[i][j] - apples[i][nc] > 0)
                result = (result + dfs(i, nc, cuts - 1, apples, dp)) % MOD;
        }
        dp[i][j][cuts] = result;
        
        return result;
    }
}

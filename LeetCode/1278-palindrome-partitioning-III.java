class Solution {

    public int palindromePartition(String s, int k) {

        int n = s.length();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) 
                cost[i][j] = minChange(s, i, j);
        }
        
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) 
            Arrays.fill(row, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) 
            dp[i][1] = cost[0][i];

        for (int p = 2; p <= k; p++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < i; j++) {

                    if (dp[j][p - 1] != Integer.MAX_VALUE) 
                        dp[i][p] = Math.min(dp[i][p], dp[j][p - 1] + cost[j + 1][i]);
                }
            }
        }

        return dp[n - 1][k];
    }

    private int minChange(String s, int l, int r) {

        int changes = 0;
        while (l < r) {

            if (s.charAt(l) != s.charAt(r)) 
                changes++;

            l++;
            r--;
        }
        
        return changes;
    }
}

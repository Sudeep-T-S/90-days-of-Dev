class Solution {

    public int getLengthOfOptimalCompression(String s, int k) {

        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) 
            Arrays.fill(row, -1);

        return helper(s, 0, k, dp);
    }

    private int helper(String s, int i, int k, int[][] dp) {

        int n = s.length();
        if (k < 0) 
            return Integer.MAX_VALUE / 2;

        if (i >= n || n - i <= k) 
            return 0;

        if (dp[i][k] != -1)
            return dp[i][k];

        int res = Integer.MAX_VALUE;
        int[] count = new int[128];
        int maxFreq = 0;
        for (int j = i; j < n; ++j) {

            count[s.charAt(j)]++;
            maxFreq = Math.max(maxFreq, count[s.charAt(j)]);
            int deletions = (j - i + 1) - maxFreq;
            if (k - deletions >= 0)
                res = Math.min(res, getLength(maxFreq) + helper(s, j + 1, k - deletions, dp));
        }

        return dp[i][k] = res;
    }

    private int getLength(int freq) {

        if (freq == 1) 
            return 1;

        if (freq < 10) 
            return 2;

        if (freq < 100) 
            return 3;
            
        return 4;
    }
}

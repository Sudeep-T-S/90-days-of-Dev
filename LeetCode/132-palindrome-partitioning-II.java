class Solution {

    public int minCut(String s) {

        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        for (int end = 0; end < n; end++) {

            for (int start = 0; start <= end; start++) {
                isPal[start][end] = (s.charAt(start) == s.charAt(end)) &&
                                    (end - start < 2 || isPal[start + 1][end - 1]);
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int end = 0; end < n; end++) {

            if (isPal[0][end]) 
                dp[end] = 0;
            else {

                for (int start = 1; start <= end; start++) {

                    if (isPal[start][end]) 
                        dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                }
            }
        }
        
        return dp[n - 1];
    }
}

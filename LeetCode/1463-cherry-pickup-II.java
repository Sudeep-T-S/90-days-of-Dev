class Solution {

    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        
        for (int[][] layer : dp)

            for (int[] row : layer)
                Arrays.fill(row, -1);
        
        dp[0][0][n-1] = grid[0][0] + grid[0][n-1];
        
        for (int r = 1; r < m; ++r) {

            for (int c1 = 0; c1 < n; ++c1) {

                for (int c2 = 0; c2 < n; ++c2) {

                    int maxPrev = -1;
                    for (int d1 = -1; d1 <= 1; ++d1) {

                        for (int d2 = -1; d2 <= 1; ++d2) {

                            int prevC1 = c1 - d1, prevC2 = c2 - d2;
                            if (prevC1 >= 0 && prevC1 < n && prevC2 >= 0 && prevC2 < n && dp[r-1][prevC1][prevC2] != -1)
                                maxPrev = Math.max(maxPrev, dp[r-1][prevC1][prevC2]);
                        }
                    }

                    if (maxPrev != -1) {
                        dp[r][c1][c2] = maxPrev + (c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2]);
                    }
                }
            }
        }
        
        int result = 0;
        for (int c1 = 0; c1 < n; ++c1)

            for (int c2 = 0; c2 < n; ++c2)
                result = Math.max(result, dp[m-1][c1][c2]);
                
        return result;
    }
}

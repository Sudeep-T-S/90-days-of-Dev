class Solution {

    public int cherryPickup(int[][] grid) {

        int n = grid.length;
        Integer[][][] dp = new Integer[n][n][n];
        int result = Math.max(0, helper(grid, dp, 0, 0, 0));

        return result;
    }

    private int helper(int[][] grid, Integer[][][] dp, int x1, int y1, int x2) {

        int y2 = x1 + y1 - x2;
        int n = grid.length;
        if (x1 >= n || y1 >= n || x2 >= n || y2 >= n || grid[x1][y1] == -1 || grid[x2][y2] == -1)
            return -1;

        if (x1 == n - 1 && y1 == n - 1)
            return grid[x1][y1];

        if (dp[x1][y1][x2] != null)
            return dp[x1][y1][x2];

        int max = Math.max(
            Math.max(helper(grid, dp, x1 + 1, y1, x2 + 1), helper(grid, dp, x1, y1 + 1, x2)),
            Math.max(helper(grid, dp, x1 + 1, y1, x2), helper(grid, dp, x1, y1 + 1, x2 + 1))
        );
        if (max == -1) 
            return dp[x1][y1][x2] = -1;

        int cherries = grid[x1][y1];
        if (x1 != x2 || y1 != y2)
            cherries += grid[x2][y2];

        dp[x1][y1][x2] = cherries + max;
        
        return dp[x1][y1][x2];
    }
}

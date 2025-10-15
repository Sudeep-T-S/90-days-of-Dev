class Solution {

    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;
        int[] dp = grid[0].clone();

        for (int i = 1; i < n; i++) {

            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, idx1 = -1;
            for (int j = 0; j < n; j++) {

                if (dp[j] < min1){ 
                    min2 = min1; min1 = dp[j]; idx1 = j;
                } else if (dp[j] < min2) 
                    min2 = dp[j];
            }

            int[] next = new int[n];
            for (int j = 0; j < n; j++) 
                next[j] = grid[i][j] + (j == idx1 ? min2 : min1);
            
            dp = next;
        }

        int ans = Integer.MAX_VALUE;
        for (int v : dp) 
            ans = Math.min(ans, v);

        return ans;
    }
}

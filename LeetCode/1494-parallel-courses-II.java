class Solution {

    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {

        int[] pre = new int[n];
        for (int[] dep : dependencies) 
            pre[dep[1] - 1] |= 1 << (dep[0] - 1);
        
        int maxMask = 1 << n;
        int[] dp = new int[maxMask];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int mask = 0; mask < maxMask; mask++) {
            
            int canTake = 0;
            for (int i = 0; i < n; i++) {

                if (((mask >> i) & 1) == 0 && (pre[i] & mask) == pre[i]) 
                    canTake |= 1 << i;
            }
            
            for (int sub = canTake; sub > 0; sub = (sub - 1) & canTake) {

                if (Integer.bitCount(sub) > k) 
                    continue;

                dp[mask | sub] = Math.min(dp[mask | sub], dp[mask] + 1);
            }
        }
        
        return dp[maxMask - 1];
    }
}

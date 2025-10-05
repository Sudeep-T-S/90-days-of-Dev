class Solution {

    private static final int MOD = 1_000_000_007;

    public int numberWays(List<List<Integer>> hats) {

        int n = hats.size();
        List<Integer>[] hatToPeople = new List[41];
        for (int i = 1; i <= 40; i++) 
            hatToPeople[i] = new ArrayList<>();

        for (int p = 0; p < n; p++) {

            for (int h : hats.get(p)) 
                hatToPeople[h].add(p);
        }

        int maxMask = 1 << n;
        long[] dp = new long[maxMask];
        dp[0] = 1;
        for (int h = 1; h <= 40; h++) {

            long[] next = Arrays.copyOf(dp, maxMask);
            for (int mask = 0; mask < maxMask; mask++) {

                if (dp[mask] == 0) 
                    continue;

                for (int p : hatToPeople[h]) {

                    if ((mask & (1 << p)) == 0) {

                        int nextMask = mask | (1 << p);
                        next[nextMask] = (next[nextMask] + dp[mask]) % MOD;
                    }
                }
            }
            dp = next;
        }
        
        return (int) dp[maxMask - 1];
    }
}

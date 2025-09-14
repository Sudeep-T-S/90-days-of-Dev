class Solution {

    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (int x : stones) 
            sum += x;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int s : stones) {

            for (int i = target; i >= s; i--)
                dp[i] = dp[i] || dp[i - s];
        }
        
        for (int i = target; i >= 0; i--) {
            if (dp[i]) 
                return sum - 2 * i;
        }

        return 0;
    }
}

class Solution {

    public int numberOfArithmeticSlices(int[] nums) {

        int n = nums.length;
        int result = 0;
        Map<Integer, Integer>[] dp = new Map[n];
        
        for (int i = 0; i < n; i++) {

            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {

                long diff = (long)nums[i] - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) 
                    continue; 
                
                int d = (int)diff;
                int countAtJ = dp[j].getOrDefault(d, 0);
                int countAtI = dp[i].getOrDefault(d, 0);
                
                dp[i].put(d, countAtI + countAtJ + 1);
                
                result += countAtJ;
            }
        }
        
        return result;
    }
}

class Solution {

    public int maxJumps(int[] arr, int d) {

        int n = arr.length;
        int[] dp = new int[n];
        int res = 1;
        for (int i = 0; i < n; i++) 
            res = Math.max(res, dfs(i, arr, d, dp));
        
        return res;
    }
    
    private int dfs(int i, int[] arr, int d, int[] dp) {

        if (dp[i] != 0) 
            return dp[i];

        int maxLen = 1;
        for (int j = i + 1; j <= Math.min(arr.length - 1, i + d) && arr[j] < arr[i]; j++) {
            maxLen = Math.max(maxLen, 1 + dfs(j, arr, d, dp));
            if (arr[j] >= arr[i]) 
                break;
        }
        
        for (int j = i - 1; j >= Math.max(0, i - d) && arr[j] < arr[i]; j--) {
            maxLen = Math.max(maxLen, 1 + dfs(j, arr, d, dp));
            
            if (arr[j] >= arr[i]) 
                break;
        }
        dp[i] = maxLen;

        return maxLen;
    }
}

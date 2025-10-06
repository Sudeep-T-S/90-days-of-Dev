class Solution {
    
    public int numDecodings(String s) {
        
        final int MOD = 1_000_000_007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[n] = 1;
        
        dp[n - 1] = countSingle(s.charAt(n - 1));
        
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = (countSingle(s.charAt(i)) * dp[i + 1]) % MOD;
            dp[i] = (dp[i] + (countDouble(s.charAt(i), s.charAt(i + 1)) * dp[i + 2]) % MOD) % MOD;
        }
        
        return (int) dp[0];
    }
    
    private int countSingle(char c) {
        
        if (c == '*') 
            return 9;
        
        if (c == '0') 
            return 0;
        
        return 1;
    }
    
    private int countDouble(char c1, char c2) {
        
        if (c1 == '*' && c2 == '*') 
            return 15;
        
        if (c1 == '*') {
            if (c2 >= '0' && c2 <= '6') 
                return 2; 
            else 
                return 1; 
        }
        
        if (c2 == '*') {
            if (c1 == '1') 
                return 9; 
            
            if (c1 == '2') 
                return 6; 
            
            return 0;
        }
        int num = (c1 - '0') * 10 + (c2 - '0');
        
        return (num >= 10 && num <= 26) ? 1 : 0;
    }
}
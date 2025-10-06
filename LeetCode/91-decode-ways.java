class Solution {
    
    public int numDecodings(String s) {
        
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') 
            return 0;

        int prev2 = 1;  
        int prev = 1;   

        for (int i = 2; i <= n; i++) {
            
            int curr = 0;
            if (s.charAt(i - 1) != '0') 
                curr += prev;

            int two = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (10 <= two && two <= 26) 
                curr += prev2;

            prev2 = prev;
            prev = curr;
        }
        
        return prev;
    }
}
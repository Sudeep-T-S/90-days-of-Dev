class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]", "");

        int left = 0,
            right = s.length()-1;

        while( left < right )

            if( s.charAt(left) == s.charAt(right) ){
                left++;
                right--;
            }else
                return false;        
        return true;
    }
}

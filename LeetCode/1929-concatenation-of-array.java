class Solution {
    public int[] getConcatenation(int[] nums) {

        int[] ans = new int[2*nums.length];
        int pos = 0;

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < nums.length; j++){
                ans[pos] = nums[j];
                pos++;
            }
        }
        return ans;
    }
}

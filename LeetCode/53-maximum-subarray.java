class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int cur_max = nums[0];

        for(int i = 1; i < nums.length; i++){
            cur_max = Math.max(nums[i], nums[i] + cur_max);
            max = Math.max(cur_max, max);
        }
        return max;
    }
}

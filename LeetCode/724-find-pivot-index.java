class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0,
            leftSum = 0;

        for (int sum : nums)
            rightSum += sum;

        for (int i = 0; i < nums.length; i++){
            rightSum -= nums[i];
            
            if(rightSum == leftSum)
                return i;

            leftSum += nums[i];
        }
        return -1;
    }
}

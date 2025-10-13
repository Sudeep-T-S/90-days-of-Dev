class Solution {

    public boolean isTrionic(int[] nums) {

        int n = nums.length;
        int i = 0;
        while (i < n - 2 && nums[i] < nums[i + 1]) 
            i++;
        
        if (i == 0) 
            return false; 

        int peak = i;
        while (i < n - 1 && nums[i] > nums[i + 1]) 
            i++;
        
        if (i == peak || i == n - 1) 
            return false; 

        while (i < n - 1 && nums[i] < nums[i + 1]) 
            i++;
        
        return i == n - 1;
    }
}

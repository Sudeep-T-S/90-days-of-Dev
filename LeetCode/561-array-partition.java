//Approach-1 Quick sort
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for(int i = 0 ; i<nums.length; i = i+2){
            sum = sum + nums[i];
        }
        return sum;
    }
}
//Time Complexity = O(nlogn)
//Space Complexity = O(logn)

//Approach-2 Count sort
class Solution {
    public int arrayPairSum(int[] nums) {
        // By Looking at Constraints
        // -10^4 -> 0
        // 0 -> 10^4
        // 10^4 -> 2* 10^4
        int k = 10000;

        int[] countArr = new int[2*k+1];

        for(int i = 0; i < nums.length; i++){
            countArr[nums[i]+k]++;
        }

        boolean isEvenIndex = true;
        int sum = 0;

        for(int i = 0; i < 2*k+1; i++){
            while(countArr[i] > 0){
                sum = sum + (isEvenIndex ? (i - k) : 0);
                countArr[i]--;
                isEvenIndex = !isEvenIndex;
            }
        }
        return sum;
        }
}
//Time Complexity = O(n+k)
//Space Complexity = O(k)

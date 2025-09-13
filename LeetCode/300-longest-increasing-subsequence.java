class Solution {
    public int lengthOfLIS(int[] nums) {

        List<Integer> lis = new ArrayList<>();
        for (int num : nums) {

            int idx = Collections.binarySearch(lis, num);
            if (idx < 0) 
                idx = -(idx + 1); 
            
            if (idx == lis.size()) 
                lis.add(num);
            else 
                lis.set(idx, num);
        }
        
        return lis.size();
    }
}

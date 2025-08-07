class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        int freqArr[] = new int[1001];

        for (int num : nums1) 
            freqArr[num]++;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : nums2) {

            if (freqArr[num] > 0) {
                list.add(num);
                freqArr[num]--;
            }
        }

        int k = list.size();
        int[] ans = new int[k];

        for (int i = 0; i < k; i++)
            ans[i] = list.get(i);

        return ans;
    }
}

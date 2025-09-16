class Solution {

    public int maxLength(List<String> arr) {

        List<Integer> masks = new ArrayList<>();
        for (String s : arr) {

            int mask = 0, dup = 0;
            for (char c : s.toCharArray()) {

                int bit = 1 << (c - 'a');
                if ((mask & bit) > 0) { 
                    dup = 1; 
                    break; 
                }
                
                mask |= bit;
            }

            if (dup == 0) 
                masks.add(mask);
        }

        return backtrack(masks, 0, 0);
    }

    private int backtrack(List<Integer> masks, int idx, int mask) {

        int max = Integer.bitCount(mask);
        for (int i = idx; i < masks.size(); i++) 

            if ((mask & masks.get(i)) == 0) 
                max = Math.max(max, backtrack(masks, i + 1, mask | masks.get(i)));

        return max;
    }
}

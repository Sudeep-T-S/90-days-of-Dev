 //Using Backtracking
class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> resultList = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(new ArrayList<>());

        while (!stack.isEmpty()) {
            List<Integer> curr = stack.pop();
            
            if (curr.size() == nums.length) {
                resultList.add(new ArrayList<>(curr));
            } else {
                
                for (int num : nums) {
                    
                    if (!curr.contains(num)) {
                        List<Integer> next = new ArrayList<>(curr);
                        next.add(num);
                        stack.push(next);
                    }
                }
            }
        }

        return resultList;
    }
}

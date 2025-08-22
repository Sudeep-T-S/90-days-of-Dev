//Using Backtracking
class Solution {
    public List<List<Integer>> combine(int n, int k) 
  
        List<List<Integer>> resultList = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(new ArrayList<>()); 

        while (!stack.isEmpty()) {
            List<Integer> curr = stack.pop();

            if (curr.size() == k) {
                resultList.add(new ArrayList<>(curr));
            } else {
                int start = curr.isEmpty() ? 1 : curr.get(curr.size() - 1) + 1;
                
                for (int i = n; i >= start; i--) {
                    List<Integer> next = new ArrayList<>(curr);
                    next.add(i);
                    stack.push(next);
                }
            }
        }

        return resultList;
    }
}

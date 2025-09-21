//Using Bottom-Up Dynamic Programming
class Solution {

    public int coinChange(int[] coins, int amount) {

        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) 
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

//Using Breadth-First Search (BFS)
class Solution {
    
    public int coinChange(int[] coins, int amount) {
        
        if (amount == 0) 
            return 0;
        
        boolean[] visited = new boolean[amount + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{amount, 0});
        
        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            int rem = current[0], steps = current[1];
            for (int coin : coins) {
                
                int nextRem = rem - coin;
                if (nextRem == 0) 
                    return steps + 1;
                
                if (nextRem > 0 && !visited[nextRem]) {
                    visited[nextRem] = true;
                    queue.offer(new int[]{nextRem, steps + 1});
                }
            }
        }
        
        return -1;
    }
}

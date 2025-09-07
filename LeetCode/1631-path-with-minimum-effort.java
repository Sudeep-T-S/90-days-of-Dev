class Solution {
    public int minimumEffortPath(int[][] heights) {

        int m = heights.length, n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int[] row : effort) 
            Arrays.fill(row, Integer.MAX_VALUE);
        effort[0][0] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[2])
        );
        heap.offer(new int[]{0, 0, 0}); 

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!heap.isEmpty()) {

            int[] curr = heap.poll();
            int x = curr[0], y = curr[1], currEffort = curr[2];
            if (x == m - 1 && y == n - 1) 
                return currEffort;

            for (int[] d : dirs) {

                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) 
                    continue;
                    
                int nextEffort = Math.max(currEffort, Math.abs(heights[nx][ny] - heights[x][y]));
                if (nextEffort < effort[nx][ny]) {
                    effort[nx][ny] = nextEffort;
                    heap.offer(new int[]{nx, ny, nextEffort});
                }
            }
        }

        return -1; 
    }
}

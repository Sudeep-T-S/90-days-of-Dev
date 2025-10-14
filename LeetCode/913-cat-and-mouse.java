class Solution {

    private static final int DRAW = 0, MOUSE_WIN = 1, CAT_WIN = 2;

    private static final int MOUSE_TURN = 0, CAT_TURN = 1;

    public int catMouseGame(int[][] graph) {

        int n = graph.length;
        int[][][] result = new int[n][n][2];
        int[][][] degree = new int[n][n][2];
        Queue<int[]> queue = new ArrayDeque<>();

        for (int m = 0; m < n; m++)

            for (int c = 0; c < n; c++) {

                degree[m][c][MOUSE_TURN] = graph[m].length;
                degree[m][c][CAT_TURN] = graph[c].length;
                for (int v : graph[c]) if (v == 0) 
                    --degree[m][c][CAT_TURN];
            }

        for (int i = 0; i < n; i++) {

            for (int turn = 0; turn < 2; turn++) {

                result[0][i][turn] = MOUSE_WIN;
                queue.offer(new int[]{0, i, turn, MOUSE_WIN});
                if (i != 0) {
                    result[i][i][turn] = CAT_WIN;
                    queue.offer(new int[]{i, i, turn, CAT_WIN});
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] state = queue.poll();
            int mouse = state[0], cat = state[1], turn = state[2], res = state[3];
            for (int[] prev : getPrev(mouse, cat, turn, graph)) {

                int pm = prev[0], pc = prev[1], pt = prev[2];
                if (result[pm][pc][pt] != DRAW) 
                    continue;

                if ((res == MOUSE_WIN && pt == MOUSE_TURN) || (res == CAT_WIN && pt == CAT_TURN)) {
                    result[pm][pc][pt] = res;
                    queue.offer(new int[]{pm, pc, pt, res});
                } else {

                    --degree[pm][pc][pt];
                    if (degree[pm][pc][pt] == 0) {
                        result[pm][pc][pt] = (pt == MOUSE_TURN ? CAT_WIN : MOUSE_WIN);
                        queue.offer(new int[]{pm, pc, pt, result[pm][pc][pt]});
                    }
                }
            }
        }

        return result[1][2][MOUSE_TURN];
    }

    private List<int[]> getPrev(int mouse, int cat, int turn, int[][] graph) {

        List<int[]> list = new ArrayList<>();
        if (turn == CAT_TURN) {

            for (int prev : graph[mouse])
                list.add(new int[]{prev, cat, MOUSE_TURN});
                
        } else {

            for (int prev : graph[cat])

                if (prev != 0) 
                    list.add(new int[]{mouse, prev, CAT_TURN});
        }

        return list;
    }
}

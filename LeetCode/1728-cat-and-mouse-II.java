class Solution {

    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {

        final int m = grid.length;
        final int n = grid[0].length();
        int nFloors = 0;
        int cat = 0;   
        int mouse = 0; 

        for (int i = 0; i < m; ++i)
    
            for (int j = 0; j < n; ++j) {

                if (grid[i].charAt(j) != '#')
                    ++nFloors;

                if (grid[i].charAt(j) == 'C')
                    cat = hash(i, j, n);
            
                else if (grid[i].charAt(j) == 'M')
                    mouse = hash(i, j, n);
            }

        Boolean[][][] mem = new Boolean[m * n][m * n][nFloors * 2];

        return canMouseWin(grid, cat, mouse, 0, catJump, mouseJump, m, n, nFloors, mem);
    }

    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean canMouseWin(String[] grid, int cat, int mouse, int turn, int catJump,
                                int mouseJump, int m, int n, int nFloors, Boolean[][][] mem) {
                                    
        if (turn == nFloors * 2)
            return false;

        if (mem[cat][mouse][turn] != null)
            return mem[cat][mouse][turn];

        if (turn % 2 == 0) {

            int i = mouse / n;
            int j = mouse % n;
            for (int[] dir : DIRS) {

                for (int jump = 0; jump <= mouseJump; ++jump) {

                    int x = i + dir[0] * jump;
                    int y = j + dir[1] * jump;
                    if (x < 0 || x == m || y < 0 || y == n)
                        break;

                    if (grid[x].charAt(y) == '#')
                        break;
                        
                    if (grid[x].charAt(y) == 'F')
                        return mem[cat][mouse][turn] = true;

                    if (canMouseWin(grid, cat, hash(x, y, n), turn + 1, catJump, mouseJump, m, n, nFloors,
                          mem))
                        return mem[cat][mouse][turn] = true;
                }
            }
            return mem[cat][mouse][turn] = false;

        } else {
        
            final int i = cat / n;
            final int j = cat % n;
            for (int[] dir : DIRS)
                for (int jump = 0; jump <= catJump; ++jump) {

                    final int x = i + dir[0] * jump;
                    final int y = j + dir[1] * jump;
                    if (x < 0 || x == m || y < 0 || y == n)
                        break;

                    if (grid[x].charAt(y) == '#')
                        break;
                    
                    if (grid[x].charAt(y) == 'F')
                        return mem[cat][mouse][turn] = false;
                
                    final int nextCat = hash(x, y, n);
                    if (nextCat == mouse)
                        return mem[cat][mouse][turn] = false;

                    if (!canMouseWin(grid, nextCat, mouse, turn + 1, catJump, mouseJump, m, n, nFloors, mem))
                        return mem[cat][mouse][turn] = false;
                }
        
            return mem[cat][mouse][turn] = true;
        }
    }

    private int hash(int i, int j, int n) {
        return i * n + j;
    }
}

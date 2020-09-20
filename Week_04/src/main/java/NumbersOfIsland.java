public class NumbersOfIsland {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int numIslands = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);
                }
            }
        }
        return numIslands;
    }

    /**
     * 深度遍历
     *
     * @param grid 网格
     * @param r    行指针
     * @param c    列指针
     */
    public void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        // 这里的判断条件，grid[r][c]=='0'必须放在最后，否则会发生数组越界的情况
        boolean stop = r >= nr || c >= nc || r < 0 || c < 0 || grid[r][c] == '0' ;
        if (!stop) {
            grid[r][c] = '0';
            dfs(grid, r - 1, c);
            dfs(grid, r + 1, c);
            dfs(grid, r, c - 1);
            dfs(grid, r, c + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumbersOfIsland numbersOfIsland = new NumbersOfIsland();
        System.out.println(numbersOfIsland.numIslands(grid));

        char[][] grid2 = new char[][]{{'1','0','1','1','0','1','1'}};
        System.out.println(numbersOfIsland.numIslands(grid2));
    }
}

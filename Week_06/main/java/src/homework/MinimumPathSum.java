package homework;

/**
 *
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] dp = new int[rowCount][colCount];
        for (int i = 1; i < rowCount; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < colCount; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rowCount - 1][colCount - 1];
    }
}

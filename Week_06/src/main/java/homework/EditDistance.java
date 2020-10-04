package homework;

public class EditDistance {

    /**
     * 求最小的编辑距离
     * 针对两个字符串，本质不同的操作实际有三种：
     * A插入
     * B插入
     * A修改
     * <p>
     * 子问题：A.subString(i)和B.subString(j)的最小编辑距离
     * DP 方程：
     * A，B最后一个字母相同
     * dp[i][j] = min(dp[i][j-1],dp[i-1][j],dp[i-1][j-1] -1) + 1
     * A，B最后一个字母不同
     * dp[i][j]=min(dp[i][j−1],dp[i−1][j],dp[i−1][j−1])
     *
     * @param word1 单词1
     * @param word2 单词2
     * @return 最小的编辑距离
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n*m == 0){
            return n+m;
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0 ; i<n+1;i++){
            dp[i][0] = i;
        }
        for (int j=0 ; j<m+1;j++){
            dp[0][j] = j;
        }
        for(int i = 1 ; i< n+1;i++){
            for(int j = 1; j<m+1;j++){
                int left = dp[i-1][j] + 1;
                int down = dp[i][j-1] + 1;
                int leftDown = dp[i-1][j-1];
                if(word1.charAt(i-1) != word2.charAt(j-1)){
                    leftDown ++;
                }
                dp[i][j] = Math.min(Math.min(left,down),leftDown);
            }
        }
        return dp[n][m];
    }
}

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * leetcode题目链接@see https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubSeq {

    /**
     * 使用动态规划进行求解
     *
     * @param text1 字符串1
     * @param text2 字符串2
     * @return 最长公共子序列
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int memo[][] = new int[chars1.length][chars2.length];
        return dp(chars1, chars2, chars1.length - 1, chars2.length - 1, memo);
    }

    private int dp(char[] chars1, char[] chars2, int i, int j, int[][] memo) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (memo[i][j] == 0) {
            if (chars1[i] == chars2[j]) {
                memo[i][j] = dp(chars1, chars2, i - 1, j - 1, memo) + 1;
            } else {
                memo[i][j] = Math.max(dp(chars1, chars2, i - 1, j, memo), dp(chars1, chars2, i, j - 1, memo));
            }
        }
        return memo[i][j];
    }

}

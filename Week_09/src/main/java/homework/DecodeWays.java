package homework;

import java.util.Arrays;

public class DecodeWays {

    /**
     * dp[i]为str[0...i]的编码总数
     * @param s 编码的字符串
     * @return 编码数量
     */
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int [] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = chars[0] == '0' ? 0:1;
        for( int i = 2 ;i<=s.length() ; i++){
            int n = (chars[i-2]-'0')*10+(chars[i-1]-'0');
            if(chars[i-1] == '0' && chars[i-2] == '0'){
                return 0;
            }
            else if (chars[i-2] == '0'){
                dp[i] = dp[i-1];
            }
            else if (chars[i-1] == '0'){
                if(n>26){
                    return 0;
                }
                dp[i] = dp[i-2];
            }
            else if (n>26){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        System.err.println((int)'1');
    }
}

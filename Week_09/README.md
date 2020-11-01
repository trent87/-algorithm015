# 动态规划 
## 动态规划的要素
动态规划 -> 分治+最优子结构
DP状态的定义（现实问题建模）
朴素递归->记忆化搜索->递推方程

## 动态规划的复杂度来源
* 状态拥有更多维度(二维、三维、或者更多)
* 状态方程更加复杂
本质：内功、逻辑思维、数学

## 编辑距离的解答要点：
* 如果word1[i]与word[j]相同，显然dp[i][j]=dp[i-1][j-1]
* 如果word1[i]与word[j]不相同，那么dp[i][j]可以通过：
  1. 在dp[i-1][j-1]的基础上做replace操作达到目的；
  2. 在dp[i-1][j]的基础上做insert操作达到目的；
  3. 在dp[i][j-1]的基础上做delete操作达到目的。
  取这三者的最小值  
  
# 字符串算法
## 基础知识   
字符串在各个编程语言中的可变性比较：  

|  语言   | 字符串是否可变  |
|  ----  | ----  |
| Python  | 不可变 |
| Java  | 不可变 |
| C++  | 可变 |
| Swift  | 可变 |
## 字符串的比较  
String a = "abc";
String b = "abc";
a == b -> false;
a.equals(b) -> true.
## 高级字符串算法  
最长子串和最长子序列
* 最长子序列
  dp[i][j] = dp[i-1][j-1]+1 (if s1[i-1]==s2[j-1])
  else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
* 最长子串
  dp[i][j] = dp[i-1][j-1]+1 (if s1[i-1]==s2[j-1])
  else dp[i][j]=0  
## 字符串匹配算法
### 暴力法  
算法复杂度O(MN)
如何加速？枚举起点的加速空间几乎没有，优化空间较大的是子串与pattern的比较。
### Rabin-Karp算法。
朴素算法：挨个比较所有字符；
rk算法：通过hash函数预先判断子串是否相等，再进行字符扽比较
rabin-krap的hash算法不同于系统hash，其对每次移动一位这样的情况计算hash时间复杂度仅为O(1)，低于系统hash函数的O(n)。  

``` java
int D = 256;
int Q = 9997;
// 计算匹配子串最高位的字符的权重
int highestPow = 1;
for(int i = 0; i < M-1 ; i++){
    highestPow = (highestPow*D)%Q;
}
// 枚举起点
for(int i= 0 ; i <=N-M;i++){
    if(patHash == txtHash){
        for(int j = 0;j < M; i++){
            if(txt.charAt(i+j) != pat.charAt(j)){
                break;
            }
        }
        if(j == M){
            return i;
        }
    }
    if( i < (N-M) ){
        // 减去最高位的hash值，加上新进字符的hash值
        txtHash = (D+(txtHash-text.charAt(i) + highestPow) + txt.charAt(i+M))%Q;
        if(txtHash<0){
            textHash+=Q;
        }
    }
}
```
### KMP
KMP的思想：当子串与目标字符串不匹配时，其实你已经知道了前面已经匹配成功的那一部分字符（包括子串和目标字符串），设法利用这个已知信息，不要把“搜索位置”移回已经比较过的位置，继续把它向后移，这样就提高了效率。
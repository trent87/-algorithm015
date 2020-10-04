import java.util.Arrays;

public class HouseRobber2 {

    /**
     * 解决环形问题：分为两种情况：抢了第一个，就不能抢最后一个；抢了最后一个就不能抢第一个
     * 利用动态规划解决问题：
     * 前n间房最多可抢的钱为dp(n),前n-1间房最多可抢的前为dp(n-1)
     * 对于第n+1间房，可抢的数量为num，则dp(n+1)有两种情况：
     * 抢了第n间，则dp(n+1) = dp(n)
     * 抢了第n-1间房，则dp(n+1) = dp(n-1) + num
     * 最终的转移方程：dp(n+1) = max(dp(n),dp(n-1)+num)
     * dp(n) = max(dp(n-1),dp(n-2) + num)
     * @param nums 表示房间可获得钱数的数组
     * @return 最多可获得的金额
     */
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int memo1[] = new int[nums.length];
        int memo2[] = new int[nums.length];
        int withStart = dp(Arrays.copyOfRange(nums,0,nums.length-1),memo1);
        int withEnd = dp(Arrays.copyOfRange(nums,1,nums.length),memo2);
        System.err.printf("with start => %d,with end => %d\n",withStart,withEnd);
        return Math.max(withStart,withEnd);
    }

    /**
     * 动态规划递归解决
     * @param nums 表示房间可获得钱数的数组
     * @param memo 缓存
     * @return 计算结果
     */
    private int dp(int[] nums,int[] memo) {
        if(nums.length == 1){
            return nums[0];
        }
        else if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        else {
            int index = nums.length - 1;
            if (memo[index] == 0) {
                memo[index] = Math.max(dp(Arrays.copyOfRange(nums,0,nums.length-2),  memo) + nums[index], dp(Arrays.copyOfRange(nums,0,nums.length-1),memo));
            }
            return memo[index];
        }
    }

    public static void main(String[] args){
        HouseRobber2 houseRobber2 = new HouseRobber2();
        //1,1,3,6,7,10,7,1,8,5,9,1,4,4,3
        //39 -> 1,1,3,6,7,10,7,1,8,5,9,1,4,4
        //41 -> 1,3,6,7,10,7,1,8,5,9,1,4,4,3
        System.err.println(houseRobber2.rob(new int[] {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3}));
    }
}

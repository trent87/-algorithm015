/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * leetcode链接@see<a href="https://leetcode-cn.com/problems/maximum-subarray/"></a>
 */
public class MaxSubArray {

    /**
     * 使用贪心算法来解决
     * @param nums 目标数组
     * @return 最大和
     */
    public int maxSubArrayWithGreedy(int[] nums){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            max = Math.max(sum, max);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

}

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums){
        int len = nums.length;
        if(len == 0){
            return false;
        }
        int sum = 0;
        for (int num: nums){
            sum += num;
        }
        if(sum % 2 != 0){
            //奇数不符合要求
            return false;
        }
        int target = sum / 2;
        boolean [][] dp = new boolean[len][target + 1];
        if(nums[0] <= target){
            dp[0][nums[0]] = true;
        }
        for(int i = 1 ; i<len;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(nums[i] == j){
                    dp[i][j] = true;
                }
                else if(nums[i] < j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[len-1][target];
    }
}

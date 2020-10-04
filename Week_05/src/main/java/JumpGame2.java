public class JumpGame2 {

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args){
        JumpGame2 jumpGame2 = new JumpGame2();
        int[] toJump = new int[]{2,3,1,1,4};
        int result = jumpGame2.jump(toJump);
        System.err.println(result);
    }
}

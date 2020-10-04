import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int difference = target - num;
            Integer index = map.get(difference);
            if (index != null) {
                res[0] = i;
                res[1] = index;
            } else {
                map.put(num, i);
            }
        }
        return res;
    }

}

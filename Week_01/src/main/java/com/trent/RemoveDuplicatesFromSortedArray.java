package com.trent;

/**
 *
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int length = removeDuplicatesFromSortedArray.removeDuplicates(nums);
        System.err.println("length after remove => " + length);
        StringBuilder s = new StringBuilder();
        boolean f = false;
        for (int i = 0 ; i < length ; i++ ){
            if(f){
                s.append(",");
            }
            else{
                f = true;
            }
            s.append(nums[i]);
        }
        System.err.println(s);

    }

}

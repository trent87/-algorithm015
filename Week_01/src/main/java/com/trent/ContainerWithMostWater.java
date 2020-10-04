package com.trent;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0)。找出其中的两条线，使得它们与轴共同构成的容器可以容纳最多的水。
 * leetcode链接 @see https://leetcode-cn.com/problems/container-with-most-water
 */
public class ContainerWithMostWater {

    /**
     * 双指针法求解
     * @param height 高度
     * @return 最大面积
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int maxArea = 0;
        while (left < right){
            int area = Math.min(height[left],height[right]) * (right - left);
            maxArea = Math.max(maxArea,area);
            if (height[left] <= height[right]){
                left ++;
            }
            else{
                right --;
            }
        }
        return maxArea;
    }

    public static void main(String [] args){
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.err.println(containerWithMostWater.maxArea(height));
    }

}

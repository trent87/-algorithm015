# 学习笔记  
## 深度优先搜索和广度优先搜索  
这里所指的搜索可以理解为遍历，比如对于一棵树，就是访问树的每个节点，且每个节点仅访问一次。
可以通过深度优先和广度优先进行搜索。

深度优先算法通过递归实现（要检查节点是否已经访问过）；

广度优先算法通过队列+循环实现。
## 贪心算法 
贪心算法是通过每步最优实现全局最优。

贪心与动规的不同在于它对每个子问题的解决方案都作出选择，<font color='red'>不能回退</font>，而动态规划<font color='red'>保存了之前的计算结果</font>，并根据以前的结果对当前进行选择，有回退


## 二分查找  

二分查找的三个前提条件：  
* 目标的单调性  
* 存在上下界
* 能够通过索引访问  

## 附
寻找一个半有序数组[4,5,6,7,0,1,2]中间无序的地方的思路以及代码
这道题目中的半无序数组和 [寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/) 中的解法是相同的
整个数组中最小的值就是变化点。这道题的解题思路与普通的二分查找的终止条件不同，如下：   

```java   
if (nums[mid] > nums[mid + 1]) {
    return nums[mid + 1];
}
if (nums[mid - 1] > nums[mid]) {
    return nums[mid];
}   
```   
整体代码如下：
```java
class Solution{

public int findChangePoint(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        while (right >= left) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
```



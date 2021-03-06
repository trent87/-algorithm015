#学习笔记  
## 位运算
为什么需要位运算：机器中的数字表示方式就是二进制  
位运算符：  
|含义|运算符|示例|  
|--|--|--|  
|按位与|&|0011->0011=0011|    
|按位或|\||0011->1011=1011|      
|按位取反|-|0011->1100|    
|按位异或|^|0011->1000=1011|  
XOR-异或，可以理解为不进位加法。
实战位运算：
* 奇偶性判断x&1=1(奇) x&1=0(偶)  
* x>>2 --> x/2  
* x&(x-1) 清零最低位的1
* x&-x 获得最低位的1  
## LRU CACHE  
缓存的两个要素：大小、替换策略
HashTable + Double LinkedList实现
## 排序  
* 比较类排序：通过比较来决定元素间的相对次序，时间复杂度不能突破O(nlogn),因此也称为非线性时间比较类排序。
* 非比较类排序：以线性时间运行，因此也称为线性时间比较排序。
[排序算法罗列](https://www.cnblogs.com/onepixel/p/7674659.html)
归并和快排具有相似性，但步骤顺序相反：
* 归并：先排左右子数组，然后合并两个有序子数组  
* 快排：先调配出左右子数组，然后对于左右子数组进行排序
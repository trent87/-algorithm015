#HashMap小结  
hashmap是java中常用的一种数据结构，是Map的基本实现类，下面从HashMap内部数据结构，应用场景，注意点几方面小结HashMap。 
下面的分析均基于jdk11的版本 
## 1.内部数据结构  
内部数据结构的分析包括：存储的数据结构及put、get的时间复杂度，如下：
* 对于HashMap来说，最小的数据存储单元是Map.Entry。在HashMap内部，由Node和TreeNode（红黑树）实现了该接口； 
Node包含的属性： key，value，hash，next（Node），TreeNode包含的属性：parent、left、right、prev、red，HashMap通过Hash表来实现Map接口中的基本功能，其hash冲突解决方法是：将hash到同一个数组下标的数据以<font color='red'>链表即Node</font>的形式保存，同时当链表的长度超过
TREEIFY_THRESHOLD时则转换为<font color='red'>红黑树</font>的方式保存；  
* 可以简单的分析一下HashMap的put和get两个方法的时间复杂度：对于单纯的hash表来说put和和get操作来说时间复杂度均为O(1);如果发生了hash冲突且基于链表的存储由于最新的元素都会追加到链表的队尾所以put
时间复杂度是O(n),get的时间的复杂度也是O(n);如果有hash冲突且基于红黑树存储则put为O(logn),get也为O(logn)。  
## 2.应用场景
hashmap的应用场景很广泛，比如缓存、各种按key进行统计。  
## 3.注意点
hashmap不是线程安全的；hashmap存储的内容是无序的

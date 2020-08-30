package com.trent;

public class PlusOne {


    /**
     * 加1的修改版，参考了leetcode的代码。
     * 直接利用原数组，利用index从数组的最后一位进行扫描，对加好之后你的结果进行判断，如果没有进位（%10 !=0）则返回；
     * 能够遍历结束，说明数组的位数不够，需要增加位数进行处理。由于是+1导致的进位，所以前一位一定是9，因此新增的位上一定是1，其余各位为0。
     * 需要遍历数组，时间复杂度为O(n),最坏情况下需要引入新的数组，空间复杂度为O(n)
     * @param digits 数字
     * @return 加一后的结果数组
     */
    public int[] plusOneV2(int[] digits){
        int len = digits.length;
        for ( int i= len - 1 ; i >= 0 ; i--){
            digits[i] ++ ;
            digits[i] %=10;
            if( digits[i] != 0){
                return digits;
            }
        }
        int[] extend = new int[len+1];
        extend[0] = 1;
        return extend;
    }

    /**
     * 很基础的想法：将数组转成对应的数值，进行加法运算后在转换成数组输出
     * 这个方法有个缺陷：受java long型最大值限制，也就是输入数组代表的数不能超过2^63 - 1
     * 基于对依赖方法的时间和空间复杂度分析，这种实现方法的时间复杂度为 O(n),空间复杂度为 O(n)
     * @param digits 输入数组
     * @return 输出结果
     */
    public int[] plusOneV1(int[] digits) {
        long num = arrayToLong(digits);
        if( num > 0 ){
            num = num + 1;
            return longToArray(num);
        }
        else{
            return digits;
        }
    }



    /**
     * 整型数组按照由高位到地位转化为对应的数值
     * 遍历了原数组，时间复杂度为O(n) 空间复杂度为 O(1)
     * @param digits 数位
     * @return 转化的数值结果
     */
    private long arrayToLong(int [] digits){
        int length = digits.length;
        if(digits.length == 0){
            return -1L;
        }
        long num = 0L;
        for (int current : digits) {
            // 值很大情况下,超过了long的范围，则会造成计算结果不正确
            num = num + current * (long) Math.pow(10, length - 1);
            length--;
        }
        return num;
    }

    /**
     * 借助字符串将数值转换为数组
     * 需要遍历字符串数组，时间复杂度为O(n),因为借用了字符串，空间复杂度为O(n)
     * @param num 数值
     * @return 结果数组
     */
    private int[] longToArray (long num){
        String totalStr = Long.toString(num);
        char[] chars = totalStr.toCharArray();
        int[] output = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            output[i] = Integer.parseInt("" + chars[i]);
        }
        return output;
    }

    public String printOutput(int[] output){
        StringBuilder out = new StringBuilder("[");
        boolean flag = false;
        for( int o : output){
            if(flag){
                out.append(",");
            }
            else{
                flag = true;
            }
            out.append(o);
        }
        out.append("]");
        return out.toString();
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        int [] inPutDigital = new int[] {9,8,7,6,5,4,3,2,1,0,4,5,6,7,8,9,5,6,7,8,5,4,4,3,3,4,4,4,4,4,6,7};
        int [] outputV1 = plusOne.plusOneV1(inPutDigital);
        int [] outputV2 = plusOne.plusOneV2(inPutDigital);
        System.out.println("plus one v1 : " + plusOne.printOutput(outputV1));
        System.out.println("================================================");
        System.out.println("plus one v2 : " + plusOne.printOutput(outputV2));
    }
}

package homework;

public class NumberOfOneBits {

    /**
     * 通过按位与和mask左移的方法实现
     * @param n 输入参数
     * @return 1的个数
     */
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for(int i = 0; i < 32;i++){
            if((n&mask)!=0){
                bits ++;
            }
            mask <<= 1;
        }
        return bits;
    }

    /**
     * 实用将低位的1置0的方法来实现
     * @param n 参数
     * @return 结果
     */
    public int hammingWeightWithLowBit(int n){
        int bits = 0;
        while(n != 0 ){
            n=n&(n-1);
            bits++;
        }
        return bits;
    }

    public static void main(String[] args){
        NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
        System.err.println(numberOfOneBits.hammingWeightWithLowBit(-3));
    }
}

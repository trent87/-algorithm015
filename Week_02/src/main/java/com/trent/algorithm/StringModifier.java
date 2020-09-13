package com.trent.algorithm;

import java.util.Arrays;
import java.util.Random;

public class StringModifier {
    public String modifyString(String s) {
        char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] chars = s.toCharArray();
        for (int i = 0 ; i < chars.length; i++){
            char thisChar = chars[i];
            char nextChar = 'B';
            char lastChar = 'A';
            if (i > 0){
                lastChar=chars[i-1];
            }
            if (i + 1 < chars.length) {
                nextChar=chars[i+1];
            }
            if (thisChar=='?'){
                int nextAlphaIndex = Arrays.binarySearch(alpha,nextChar);
                int lastAlphaIndex = Arrays.binarySearch(alpha,lastChar);
                int choose = -1;
                while (choose < 0 || choose == nextAlphaIndex || choose == lastAlphaIndex){
                    choose = new Random().nextInt(25);
                }
                chars[i] = alpha[choose];
            }
        }
        return new String(chars);
    }

    public static void main(String[] args){
        StringModifier stringModifier = new StringModifier();
//        int choose = -1;
//        while (choose < 0 ){
//            choose = new Random().nextInt(25);
//            System.out.println(choose);
//        }
        System.out.println(stringModifier.modifyString("??yw?ipkj?"));


    }
}

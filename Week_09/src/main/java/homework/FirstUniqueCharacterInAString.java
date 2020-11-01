package homework;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character,Integer> countMap = new HashMap<>(26);
        char[] chars = s.toCharArray();
        for(int i = 0;i<s.length();i++){
            int count = countMap.getOrDefault(chars[i],0);
            count++;
            countMap.put(chars[i],count);
        }
        for(int i = 0;i<chars.length;i++ ){
            int count = countMap.getOrDefault(chars[i],0);
            if(count == 1){
                return i;
            }
        }
        return -1;
    }
}

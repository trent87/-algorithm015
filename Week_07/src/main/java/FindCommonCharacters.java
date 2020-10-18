import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        Map<Character, List<Integer>> charCount = new HashMap<>();
        int index = 0;
        for (String s : A) {
            char[] cs = s.toCharArray();
            for (char c : cs) {
                List<Integer> counts = charCount.getOrDefault(c, new ArrayList<>(A.length));
                if (counts.isEmpty()) {
                    for (int i = 0; i < A.length; i++) {
                        counts.add(0);
                    }
                }
                Integer count = counts.get(index);
                count++;
                counts.set(index, count);
                charCount.put(c, counts);
            }
            index++;
        }
        charCount.forEach((k, v) -> {
            if (v.size() == A.length) {
                int min = Integer.MAX_VALUE;
                for (Integer count : v) {
                    min = Math.min(count, min);
                }
                for (; min > 0; min--) {
                    res.add(new String(new char[]{k}));
                }
            }
        });
        return res;
    }

    public static void main(String[] args) {
        String[] A = new String[]{"bella", "label", "roller"};
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        List<String> res = findCommonCharacters.commonChars(A);
        System.err.println(res);
    }

}

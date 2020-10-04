import java.util.*;

public class Test {
    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 词语接龙
     *
     * @param beginWord 起始词
     * @param endWord   结束词
     * @param wordList  词典
     * @return 路径长度
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //初始化一个通配单词组成的词典
        //对单词进行广度遍历
        int wordLength = beginWord.length();
        Set<String> visited = new HashSet<>();
        Map<String, List<String>> wildcardWordDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < wordLength; i++) {
                String wildcardWord = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> words = wildcardWordDict.get(wildcardWord);
                if (words == null) {
                    words = new ArrayList<>();
                }
                words.add(word);
                wildcardWordDict.put(wildcardWord, words);
            }
        }
        Deque<Pair<String, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(beginWord, 1));
        while (!deque.isEmpty()) {
            Pair<String, Integer> pair = deque.remove();
            String word = pair.key;
            Integer level = pair.value;
            for (int i = 0; i < wordLength; i++) {
                String wildcardWord = word.substring(0, i) + "*" + word.substring(i + 1);
                for (String w : wildcardWordDict.getOrDefault(wildcardWord, new ArrayList<>())) {
                    if (w.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(w)) {
                        visited.add(w);
                        deque.add(new Pair<>(w, level + 1));
                    }
                }
            }
        }
        return 0;
    }
}

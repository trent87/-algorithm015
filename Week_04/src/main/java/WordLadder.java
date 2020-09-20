import java.util.*;

/**
 * 词语接龙
 */
public class WordLadder {

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
     * 广度优先遍历
     * @param beginWord 起始词
     * @param endWord 结束词
     * @param wordList 词典
     * @return 路径长度
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLength = beginWord.length();
        Map<String, List<String>> dict = new HashMap<>();
        wordList.forEach(word -> fillWildcardWordDict(word, dict));
        Deque<Pair<String, Integer>> deque = new ArrayDeque<>();
        deque.add(new Pair<>(beginWord, 1));
        Set<String> visited = new HashSet<>();
        while (!deque.isEmpty()) {
            Pair<String, Integer> node = deque.remove();
            String word = node.key;
            int level = node.value;
            for (int i = 0; i < wordLength; i++) {
                String wildcardWord = word.substring(0, i) + "*" + word.substring(i + 1);
                for (String adjacentWord : dict.getOrDefault(wildcardWord, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        deque.add(new Pair<>(adjacentWord, level + 1));
                    }
                }
            }
        }
        return 0;
    }

    /**
     * 生成通配单词，并填充到词典
     * @param word 单词
     */
    private void fillWildcardWordDict(String word, Map<String, List<String>> wildChardWordDict) {
        for (int i = 0; i < word.length(); i++) {
            String wildcardWord = word.substring(0, i) + '*' + word.substring(i + 1);
            List<String> wordList = wildChardWordDict.computeIfAbsent(wildcardWord, k -> new ArrayList<>());
            wordList.add(word);
            wildChardWordDict.put(wildcardWord, wordList);
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        WordLadder wordLadder = new WordLadder();
        System.err.println(wordLadder.ladderLength(beginWord, endWord, wordList));
    }


}

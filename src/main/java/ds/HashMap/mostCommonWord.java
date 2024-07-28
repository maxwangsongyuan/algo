package ds.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class mostCommonWord {
    /*
    Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

    The words in paragraph are case-insensitive and the answer should be returned in lowercase.

    方法：
    1. 用hashmap存储paragraph中的单词
    2. 用hashset存储banned中的单词
    3. 遍历paragraph，对每个单词进行处理
    4. 如果单词不在banned中，就更新hashmap中的单词出现次数,
    单词作为key， 出现次数作为value
    5. 返回出现次数最多的单词

     */
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = Set.of(banned);

        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");

        for (String word : words) {
//            System.out.println(word);
            Integer value = map.getOrDefault(word, 0);
            if (!set.contains(word)) {
                map.put(word, value + 1);
            }
//            map.compute(word, (k, v) -> v == null ? 1 : v + 1);

        }
//        System.out.println(map);
        Optional<Map.Entry<String, Integer>> optional = map.entrySet().stream().max(Map.Entry.comparingByValue());
        return optional.map(Map.Entry::getKey).orElse(null);
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> set = Set.of(banned);

        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");

        for (String word : words) {
//            System.out.println(word);
            Integer value = map.getOrDefault(word, 0);
            if (!set.contains(word)) {
                map.put(word, value + 1);
            }
//            map.compute(word, (k, v) -> v == null ? 1 : v + 1);

        }

        int max = 0;
        String maxKey = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;

    }

    public static void main(String[] args) {
        mostCommonWord mostCommonWord = new mostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord.mostCommonWord(paragraph, banned)); // Output: "ball"

        System.out.println(mostCommonWord.mostCommonWord2(paragraph, banned)); // Output: "ball"
    }
}

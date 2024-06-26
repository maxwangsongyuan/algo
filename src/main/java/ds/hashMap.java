package ds;

import java.util.*;

public class hashMap {
    public void hashMapBasic() {
        Map<String, String> map = new HashMap<>();
        map.put("x", "Person 1");
        map.get("x");
        map.getOrDefault("apple", "ss");
        map.containsKey("apple");
        map.containsValue(1);
        map.remove("apple"); //remove key
        map.replace("apple", "ss");
        map.putIfAbsent("ssss", "ssss"); //only put if the key is not present, otherwise do nothing


        for (Map.Entry<String, String> entry : map.entrySet()) {
            entry.getKey();
            entry.getValue();
        }

        for (String key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }

        for (String value : map.values()) {
            System.out.println("Value: " + value);
        }
    }


    //Use Case: Count the frequency of elements in a collection
    public static void x() {
        String s = "example";
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        System.out.println(frequencyMap); // Output: {a=1, e=2, x=1, p=1, l=1, m=1}
    }

    //Use Case: Store previously computed results to avoid redundant calculations
    public class Fibonacci {
        private Map<Integer, Integer> memo = new HashMap<>();

        public int fib(int n) {
            if (n <= 1) return n;
            if (memo.containsKey(n)) return memo.get(n);

            int result = fib(n - 1) + fib(n - 2);
            memo.put(n, result);
            return result;
        }

        public void main(String[] args) {
            Fibonacci fibonacci = new Fibonacci();
            System.out.println(fibonacci.fib(10)); // Output: 55
        }
    }

    //Use Case: Group elements by some attribute.
    public class GroupWords {
        public static void main(String[] args) {
            String[] words = {"apple", "banana", "avocado", "blueberry", "cherry"};
            Map<Character, List<String>> groups = new HashMap<>();

            for (String word : words) {
                char firstLetter = word.charAt(0);
                groups.putIfAbsent(firstLetter, new LinkedList<>());
                groups.get(firstLetter).add(word);
            }

            System.out.println(groups); // Output: {a=[apple, avocado], b=[banana, blueberry], c=[cherry]}
        }
    }


    public boolean uniqueNumOccurrences(int[] arr) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (int num: arr) {
            hash.put(num, hash.getOrDefault(num, 0) +1);
        }

        Set<Integer> x = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry: hash.entrySet()) {
            if (x.contains(entry.getValue())) {
                return false;
            }

            x.add(entry.getValue());

        }

        return true;
    }

    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }


}

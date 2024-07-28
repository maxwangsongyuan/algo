package ds.HashMap;

import java.util.Arrays;

public class uniqueFirstChar {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (char ch: s.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        System.out.println(Arrays.toString(freq));

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        uniqueFirstChar uniqueFirstChar = new uniqueFirstChar();
        String s = "leetcode";
        System.out.println(uniqueFirstChar.firstUniqChar(s)); // Output: 0
    }
}

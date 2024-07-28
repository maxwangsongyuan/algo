package ds.HashMap;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
       int[] freq = new int[26];

       for (char ch: s.toCharArray()) {
           freq[ch - 'a'] += 1;
       }

       for (char ch: t.toCharArray()) {
           freq[ch - 'a'] -= 1;
       }

       return Arrays.stream(freq).allMatch(i -> i == 0);
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(validAnagram.isAnagram(s, t)); // Output: true
    }
}

package ds.HashMap;

import java.util.HashMap;

public class lengthOfLongestSubstring {

    /*
   思路：

   [(a,3) (b,1) (c,2)]

     b
       e
    abcabcbb

   要点：
    1.用 begin 和 end 表示子串开始和结束位置，b、e之间始终是不含重复字符的字串
    2.用hash表记录所有e走过的值和其索引，遇到重复的更新其索引即可
    3.从左向右查看每个字符, 如果:
     - 没遇到重复字符，调整 e
     - 遇到重复的字符，调整 b
     - 将当前字符放入 hash 表
    4.end - begin + 1 是当前子串长度， 求最大值即可

 */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0;
        int maxLen = 0;
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) { //重复
                begin = Math.max(map.get(c) + 1, begin); //abba, 第二个a的时候，begin = 2, map.get(c) = 0
                map.put(c, end);
            } else {
                map.put(c, end);
            }
            System.out.println(s.substring(begin, end + 1));
            maxLen = Math.max(maxLen, end - begin + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring lengthOfLongestSubstring = new lengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abba")); // Output: 3
    }
}

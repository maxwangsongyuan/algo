package ds.HashMap;

import java.util.HashSet;
import java.util.Set;

public class singleNumber {
    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    方法：
    1. 用hashset存储元素
    2. 遍历数组，如果元素在hashset中，就删除该元素，否则就添加该元素
    3. 返回该元素
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        return set.iterator().next();
    }

    /*
    approach 2: bit manipulation
    1. a ^ 0 = a
    2. a ^ a = 0

    方法：
    1. 用一个变量存储结果
    2. 遍历数组，对每个元素进行异或操作
    3. 返回结果


     */
    public int singleNumber2(int[] nums) {
        int result = 0;

        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

    public static void main(String[] args) {
        singleNumber singleNumber = new singleNumber();
        int[] nums = {2, 3, 1, 2, 1};
        System.out.println(singleNumber.singleNumber(nums)); // Output: 1

        System.out.println(singleNumber.singleNumber2(nums)); // Output: 1
    }
}

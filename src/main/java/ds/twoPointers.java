package ds;

public class twoPointers {
    //The first pointer (i) keeps track of the position where the next non-zero element should go.
    //The second pointer (j) scans through the array to find non-zero elements.
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i =0;
        for (int j =0;j<n;j++) {
            if(nums[j] != 0)
            {
                nums[i] = nums[j];
                i++;
            }
        }

        for(int k = i ; k<n ;k++) {
            nums[k] = 0;
        }
    }

    // two pointers, one from the start, one from the end
    // if same -> more left and right
    // if not same -> move right only
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    // compare the left and right height, move the smaller one inwards
    public int containerWithMostWater(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }


}

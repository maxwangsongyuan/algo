package ds;

public class slidingWindow {

    public double findMaxAverage(int[] nums, int k) {
        // Calculate the sum of the first window of size k
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        int currentSum = maxSum;

        // Slide the window over the array
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        // Calculate the maximum average
        return (double) maxSum / k;
    }



    public static int minSizeSubarraySum(int[] arr, int S) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end]; // Add the next element to the window

            // Shrink the window as small as possible while the window sum is larger than S
            while (windowSum >= S) {
                minLength = Math.max(minLength, end - start + 1); // Update the minimum length
                windowSum -= arr[start]; // Subtract the element going out
                start++; // Slide the window ahead
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}

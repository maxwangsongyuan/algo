package ds.Heap;

import java.util.PriorityQueue;

public class KthLargestElementinArray {
    //leetcode 215. Kth Largest Element in an Array

    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
     * not the kth distinct element.
     *
     * 1. Use a minHeap to store the k largest elements
     * 2. Iterate through the array and add each element to the minHeap
     * 3. If the size of the minHeap exceeds k, remove the smallest element
     * 4. The top of the minHeap will be the kth largest element
     * @param nums
     */
    public int findKthLargest(int[] nums, int k) {
        // 小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            // 如果堆的大小超过k，弹出堆顶元素
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementinArray kthLargestElementinArray = new KthLargestElementinArray();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(kthLargestElementinArray.findKthLargest(nums, k)); // 5
    }
}



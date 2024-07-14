package ds.Heap;

import java.util.PriorityQueue;

public class KthLargestElementinaStream {
    class KthLargest {
        PriorityQueue<Integer> minHeap;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            minHeap.offer(val);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            return minHeap.peek();
        }

    }

    public static void main(String[] args) {
        KthLargestElementinaStream kthLargestElementinaStream = new KthLargestElementinaStream();
        int k = 3;
        int[] nums = {4,5,8,2};
        KthLargest kthLargest = kthLargestElementinaStream.new KthLargest(k, nums);
        System.out.println(kthLargest.add(3)); // 4
        System.out.println(kthLargest.add(5)); // 5
        System.out.println(kthLargest.add(10)); // 5
        System.out.println(kthLargest.add(9)); // 8
        System.out.println(kthLargest.add(4)); // 8
    }

}

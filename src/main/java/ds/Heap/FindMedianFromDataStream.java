package ds.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    class MedianFinder {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;

        public MedianFinder() {
//            minHeap = new PriorityQueue<>();
//            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
            maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        }

        /**
         * 1. Add the number to the maxHeap
         * 2. Add the top of the maxHeap to the minHeap
         * 3. If the size of the maxHeap is less than the minHeap,
         * add the top of the minHeap to the maxHeap
         *
         * maxHeap is used to store the smaller half of the numbers
         * minHeap is used to store the larger half of the numbers
         *
         * size of maxHeap is always greater than or equal to the size of minHeap
         * @param num
         */
        public void addNum(int num) {
            // add the number to the maxHeap
            maxHeap.offer(num);
            // add the top of the maxHeap to the minHeap
            minHeap.offer(maxHeap.poll());
            // balance the size of the two heaps
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }
        }

    }

    public static void main(String[] args) {
        FindMedianFromDataStream findMedianFromDataStream = new FindMedianFromDataStream();
        MedianFinder medianFinder = findMedianFromDataStream.new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // 2
    }
}

package ds.Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class queue {
    public int firstUniqChar(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        Queue<Character> charQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();

        // Process the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            charQueue.add(c);
            indexQueue.add(i);

            // Remove repeating characters from the front of the queue
            while (!charQueue.isEmpty() && frequencyMap.get(charQueue.peek()) > 1) {
                charQueue.poll();
                indexQueue.poll();
            }
        }

        // The front of the indexQueue is the index of the first non-repeating character
        return indexQueue.isEmpty() ? -1 : indexQueue.peek();
    }


    public class RecentCounter {
        private Queue<Integer> queue;

        public RecentCounter() {
            this.queue = new LinkedList<>();
        }

        public int ping(int t) {
            // Add the new request time to the queue
            queue.add(t);

            // Remove requests that are older than 3000 milliseconds from the current time
            while (!queue.isEmpty() && queue.peek() < t - 3000) {
                queue.poll();
            }

            // The size of the queue is the number of requests in the last 3000 milliseconds
            return queue.size();
        }
    }
}

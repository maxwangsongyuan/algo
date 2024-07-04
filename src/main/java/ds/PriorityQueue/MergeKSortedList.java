package ds.PriorityQueue;



import java.util.PriorityQueue;

// leetcode 23. Merge k Sorted Lists
public class MergeKSortedList {

    /*
                    p
    1 -> 4 -> 5 -> null
                    p
    1 -> 3 -> 4 -> null
               p
    2 -> 6 -> null

    小顶堆

    空链表  1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

     */

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 将所有链表的头结点加入到小顶堆中
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // 不断从堆中取出最小元素，加入到新链表中
        ListNode s = new ListNode(-1, null); // 哨兵
        ListNode p = s; // pointer 指向哨兵
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll(); // 弹出堆顶元素
            p.next = min; // 将堆顶元素加入到新链表中
            p = min; // 指针后移

            // 如果堆顶元素还有下一个元素，将下一个元素加入到堆中
            if (min.next != null) {
                minHeap.offer(min.next);
            }
        }
        return s.next;
    }


    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        // Test the mergeKLists method
        ListNode[] lists = new ListNode[3];
        MergeKSortedList mergeKSortedList = new MergeKSortedList();

        // Create the first list: 1 -> 4 -> 5
        lists[0] = mergeKSortedList.new ListNode(1);
        lists[0].next = mergeKSortedList.new ListNode(4);
        lists[0].next.next = mergeKSortedList.new ListNode(5);

        // Create the second list: 1 -> 3 -> 4
        lists[1] = mergeKSortedList.new ListNode(1);
        lists[1].next = mergeKSortedList.new ListNode(3);
        lists[1].next.next = mergeKSortedList.new ListNode(4);

        // Create the third list: 2 -> 6
        lists[2] = mergeKSortedList.new ListNode(2);
        lists[2].next = mergeKSortedList.new ListNode(6);

        // Merge the three lists
        ListNode result = mergeKSortedList.mergeKLists(lists);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

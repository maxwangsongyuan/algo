package ds.linkedList;

public class HasCycle {
    // Time: O(n), Space: O(1)
    /**
     * leetcode 141
     * 快慢指针
     *  - 慢指针每次走一步
     *  - 快指针每次走两步
     *  - 如果有环，快指针会追上慢指针
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps

            if (slow == fast) {
                return true; // Cycle detected
            }
        }

        return false; // No cycle
    }

    // Time: O(n), Space: O(1)
    /**
     * leetcode 142
     * 快慢指针
     *  - 慢指针每次走一步
     *  - 快指针每次走两步
     *  - 如果有环，快指针会追上慢指针
     *  - 慢指针从头开始，快指针保持不动
     *  - 慢指针和快指针每次走一步，相遇的地方就是环的起点
     */

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;       // Move slow pointer one step
            fast = fast.next.next;  // Move fast pointer two steps

            if (slow == fast) {
                // Cycle detected, find where cycle begins
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Cycle detected
            }
        }

        return null; // No cycle
    }


}

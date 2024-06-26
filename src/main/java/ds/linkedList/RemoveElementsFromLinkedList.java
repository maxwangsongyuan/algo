package ds.linkedList;

public class RemoveElementsFromLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
     // p1  p2
     // s -> 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(666, head);
        ListNode p1 = sentinel;
        ListNode p2 = sentinel.next;
        while (p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next; // remove p2 from linkedlist
                p2 = p2.next; // move p2 to next node
            } else {
                p2 = p2.next; // move p2 to next node
                p1 = p1.next; // move p1 to next node
            }

        }
        return sentinel.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if ( head == null) {
            return null;
        }

        if (head.val == val) {
            return removeElements2(head.next, val);
        } else {
            head.next = removeElements2(head.next, val);
            return head;
        }
    }

}

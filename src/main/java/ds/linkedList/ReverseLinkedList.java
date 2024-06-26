package ds.linkedList;

import java.util.List;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // Save the next node
            curr.next = prev;          // Reverse the current node's pointer
            prev = curr;               // Move prev to the current node
            curr = next;               // Move curr to the next node
        }

        return prev; // prev will be the new head of the reversed list
    }

    public ListNode reverseList2(ListNode head) {
        ListNode n1 = null;
        ListNode curr = head;

        while (curr != null) {
            n1 = new ListNode(curr.val, n1);
            curr = curr.next;
        }

        return n1;
    }

    public ListNode reverseList3(ListNode head) {
        if (head.next == null || head == null) {
            return head; // 最后一个节点
        }

        ListNode last = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    // o1 -> old head
    // o2 -> old head.next
    // n1 -> new head
    //step 1: break o2 from linkedlist
    //step 2:  point o2 to n1, which is head
    //step 3:  move n1 to o2, this is to keep track of the new head
    //step 4:  move o2 to o1.next to continue the loop
    public ListNode reverseList4(ListNode o1) {
        ListNode o2 = o1.next;
        ListNode n1 = o1; //always be the first node

        while (o2 != null) {
            o1.next = o2.next; //step 1
            o2.next = n1; //step 2
            n1 = o2; //step 3
            o2 = o1.next; //step 4
        }

        return n1;
    }


    // o1 -> old head
    // o2 -> old head.next
    // n1 -> new head
    //step 1:  move o1 to head of n1
    //step 2:  make n1 to point to the new head, which is o1
    //step 3:  move o1 to o2 to continue the loop
    public ListNode reverseList5(ListNode o1) {
        ListNode n1 = null; //represent new linkedlist

        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1; //step 1
            n1 = o1; //step 2
            o1 = o2;    //step 3
        }

        return n1;
    }


    public static void main(String[] args) {


        ListNode second = new ListNode(2, null);
        ListNode head = new ListNode(1, second);

        ListNode n1 = new ReverseLinkedList().reverseList5(head);

        System.out.println(n1);
    }
}




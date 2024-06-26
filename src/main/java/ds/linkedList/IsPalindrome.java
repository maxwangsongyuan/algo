package ds.linkedList;

public class IsPalindrome {

    /**
     * 1. Find the middle of the linked list
     * 2. Reverse the second half
     * 3. Compare the first half and the reversed second half
     */
    public boolean isPalindrome(ListNode head) {
        ListNode middle = findMiddle(head);
        System.out.println(middle);
        ListNode reversed = reverse(middle);
        System.out.println(reversed);

        while (reversed != null) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }

        return true;

    }

    private ListNode findMiddle(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        return s;
    }


    private ListNode reverse(ListNode head) {
        ListNode o1 = head;
        ListNode n1 = null;

        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }

        return n1;
    }

    //--------------------------------------------


    public boolean isPalindromeRefined(ListNode head) {
        ListNode f = head;
        ListNode s = head;

        ListNode n1 = null;
        ListNode o1 = head;

        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;

            //reverse the first half
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }

        System.out.println(n1);
        System.out.println(s);

        //determine if the linkedlist has odd number of nodes
        // if the fast pointer is not null, then the linked list has odd number of nodes

        //                     f
        //           s
        // 1 -> 2 -> 3 -> 2 -> 1 -> null


        //                       f
        //           s
        // 1 -> 2 -> 2 -> 1 -> null

        if (f != null) {
            s = s.next;
        }

        ListNode reversed = n1;

        //compare the reversed first half and the second
        while (reversed != null) {
            if (s.val != reversed.val) {
                return false;
            }
            s = s.next;
            reversed = reversed.next;
        }

        return true;

    }


    public static void main(String[] args) {

        ListNode head2 = ListNode.of(1, 2, 4, 2, 1);
        System.out.println(new IsPalindrome().isPalindromeRefined(head2));

        ListNode head = ListNode.of(1, 2, 3, 2, 1);
        System.out.println(new IsPalindrome().isPalindrome(head));

        head = ListNode.of(1, 2, 3, 3, 2, 1);
        System.out.println(new IsPalindrome().isPalindrome(head));

        head = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(new IsPalindrome().isPalindrome(head));
    }
}

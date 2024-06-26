package ds.linkedList;

public class RemoveNthNodeFromBack {

    /**
     * 方法1: 递归

     recursion（ListNode p=1, int n=2){
        recursion（ListNode p=2, int n=2){
            recursion（ListNode p=3, int n=2){
                recursion（ListNode p=4, int n=2){
                    recursion（ListNode p=5, int n=2){
                        recursion（ListNode p=null, int n=2){
                            return 0;
                        }
                        return 1;
                    }
                    return 2;
                }
                if (上一级的返回值 == n == 2){
                    删除
                }
                return 3;
            }
            return 4;
        }
        return 5;
     }

     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(666, head);
        recursion(sentinel, n);
        return sentinel.next;
    }

    // set the prev node as nth node from the end
    // remove the next node, which is the one actually needs to be removed
    public int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }

        int nth = recursion(p.next, n);
        if (nth == n) {
            p.next = p.next.next;
        }

        return nth + 1;
    }

    //fast and slow pointers
    // fast pointer moves n steps first
    // then move both pointers until fast pointer reaches the end
    // slow pointer will be at the node before the one needs to be removed
    //


    /**
     * 方法2: 快慢指针

     n = 2
     p1  指针1
     p2  指针2 - 与指针1中间隔n个节点
     s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
          p2
     s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
               p2
     s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
                    p2
     s -> 1 -> 2 -> 3 -> 4 -> 5 -> null
     ...
                    p1              p2   p2指向null的时候停止，这个时候p1指向倒数第3个节点
     s -> 1 -> 2 -> 3 -> 4 -> 5 -> null

     s -> 1 -> 2 -> 3 -> 5 -> null     p1.next = p1.next.next 即为删除 p1.next
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode sentinel = new ListNode(666, head);
        ListNode slow = sentinel;
        ListNode fast = sentinel;

        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return sentinel.next;
    }

}

package ds.linkedList;

public class DeleteAllDuplicates {

    /**
     * 方法1:递归
     *
     * 递归函数负责返回：从当前节点（我）开始，完成去重的链表
     * - 若我与next重复，一直找到下一个不重复的节点，以它的返回结果为准
     * - 若我与next不重复，返回我，同时更新next
     *
     * deleteDuplicates1（ListNode p=1){
     *   deleteDuplicates1（ListNode p=1){
     *      deleteDuplicates1（ListNode p=1){
     *          deleteDuplicates1（ListNode p=2){
     *              deleteDuplicates1（ListNode p=3){
     *                  //只剩一个节点，返回p 3;
     *              }
     *              返回我，更新next 2 + next
     *          }
     *          返回我，更新next 1 + next
     *      }
     *      向下寻找
     *   }
     *   向下寻找
     * }
     *
     */

    public ListNode deleteDuplicatesRecursion(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }

        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            return deleteDuplicatesRecursion(x);
        } else {
            p.next = deleteDuplicatesRecursion(p.next);
            return p;
        }
    }

    /**
     * 方法2:两个指针

     P1：哨兵指针，用来删除重复的节点
     P2
     P3

     P1   p2   P3
     s -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> null     遇到重复的，移动P3；
     P1   p2             P3
     s -> 1 -> 1 -> 1 -> 2 -> 3 -> 3 -> null     当P3找到跟P2不一样的值时，P1.next = P3
     P1   p2   P3
     s -> 2 -> 3 -> 3 -> null                    如果没有重复的，移动P1、P2、P3，
          P1   p2   P3
     s -> 2 -> 3 -> 3 -> null                    继续之前的操作，直到P3或者p2为null；
          P1   p2         P3
     s -> 2 -> 3 -> 3 -> null
          P1   p2   P3
     s -> 2 -> null
     */
    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode(666, head);
        ListNode p1 = sentinel;


        while (p1.next != null && p1.next.next != null) {
            ListNode p2 = p1.next;
            ListNode p3 = p2.next;

            if (p2.val == p3.val) {
                while (p3 != null && p2.val == p3.val ) {
                    p3 = p3.next;
                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
        }
        return sentinel.next;
    }

}

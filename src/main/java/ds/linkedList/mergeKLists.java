package ds.linkedList;

import java.util.ArrayList;
import java.util.List;

public class mergeKLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        while (lists.size() > 1) {
            List<ListNode> newMergedList = new ArrayList<>();
            for (int i = 0; i < lists.size(); i += 2) {
                ListNode l1 = lists.get(i);
                ListNode l2 = (i + 1 < lists.size()) ? lists.get(i + 1) : null;
                ListNode merged = mergeTwoLists(l1, l2);
                newMergedList.add(merged);
            }
            lists = newMergedList;
        }

        return lists.get(0);
    }


    /**
     * divide and conquer
     */

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return split(lists, 0, lists.length - 1);
    }

    public ListNode split(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }

        int mid = (l + r) >>> 1;
        ListNode l1 = split(lists, l, mid);
        ListNode l2 = split(lists, mid + 1, r);
        return mergeTwoLists(l1, l2);
    }




    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(555, null); //sentinel
        ListNode p = s;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }

        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return s.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.of(1, 4, 5);
        ListNode l2 = ListNode.of(1, 3, 4);
        ListNode l3 = ListNode.of(2, 6);
        List<ListNode> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        System.out.println(new mergeKLists().mergeKLists(lists));
    }
}

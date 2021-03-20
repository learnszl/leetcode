import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author szl
 * @Date 2021/3/20 10:26
 * @Description
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> res = new ArrayList<>();
        res = cal(lists);
        if (res.size() == 0)
            return null;
        Collections.sort(res);
        ListNode head = new ListNode(res.get(0));
        ListNode p = head;
        for (int i = 1; i < res.size(); i++) {
            p.next = new ListNode(res.get(i));
            p = p.next;
        }
        return head;
    }

    public ArrayList<Integer> cal(ListNode[] lists) {
        ArrayList<Integer> res = new ArrayList<>();
        for (ListNode list : lists) {
            ListNode p = list;
            while (p != null) {
                res.add(p.val);
                p = p.next;
            }
        }
        return res;
    }
}
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0)
//            return null;
//        ListNode res = lists[1];
//        for (int i = 1; i < lists.length; i++) {
//            res = mergeTwoLists(res, lists[i]);
//        }
//        return res;
//    }
//
//    //    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
////        if (l1 == null)
////            return l2;
////        else if (l2 == null)
////            return l1;
////        else if (l1.val < l2.val) {
////            l1.next = mergeTwoLists(l1.next, l2);
////            return l1;
////        } else {
////            l2.next = mergeTwoLists(l1, l2.next);
////            return l2;
////        }
////    }
////}
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode res = new ListNode(-1);
//        ListNode p = res;
//        while (l1 != null && l2 != null) {
//            if (l1.val <= l2.val) {
//                p.next = l1;
//                l1 = l1.next;
//            } else {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            p = p.next;
//        }
//        p.next = l1 == null ? l2 : l1;
//        return res.next;
//    }
//}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
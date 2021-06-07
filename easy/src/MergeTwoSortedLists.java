/**
 * @Author szl
 * @Date 2021/3/16 21:46
 * @Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode p = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return res.next;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1);
        ListNode l1p = l1;
        l1p.next = new ListNode(3);
        l1p = l1p.next;
        l1p.next = new ListNode(5);
        l1p.next.next = null;
        ListNode l2 = new ListNode(2);
        ListNode l2p = l2;
        l2p.next = new ListNode(3);
        l2p = l2p.next;
        l2p.next = new ListNode(6);
        l2p = l2p.next;
        l2p.next = new ListNode(7);
        l2p.next.next = null;
        ListNode p = mergeTwoSortedLists.mergeTwoLists1(l1, l2);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}

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

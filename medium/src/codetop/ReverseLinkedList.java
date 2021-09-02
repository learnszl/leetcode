package codetop;


/**
 * @Author szl
 * @Date 2021/9/2 10:35
 * @Description
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {//迭代
        if (head == null || head.next == null)
            return head;
        ListNode p = head, curr = null, q = p.next;
        p.next = null;
        while (q != null) {
            curr = q;
            q = q.next;
            curr.next = p;
            p = curr;
        }
        return curr;
    }

    public ListNode reverseList1(ListNode head) {
        return backtrack(head, null);
    }

    private ListNode backtrack(ListNode head, ListNode pre) {
        if (head == null)
            return null;
        ListNode next = head.next;
        head.next = pre;
        return backtrack(next, head);
    }
}

package codetop;


/**
 * @Author szl
 * @Date 2021/11/2 10:38
 * @Description
 */
public class p2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode r = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = (x + y + carry) % 10;
            carry = (x + y + carry) / 10;
            r.next = new ListNode(sum);
            r = r.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry == 1)
            r.next = new ListNode(1);
        return dummyHead.next;
    }
}

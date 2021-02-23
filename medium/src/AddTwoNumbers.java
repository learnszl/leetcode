/**
 * @Author szl
 * @Date 2021/2/23 20:34
 * @Description
 */
public class AddTwoNumbers {
    static class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, p = null;
//        int r1 = 0,r2 = 0;//l1,l2链表长度
//        while (l1.next != null){
//            r1++;
//            l1 = l1.next;
//        }
//        while (l2.next != null){
//            r2++;
//            l2 = l2.next;
//        }
        int carry = 0;//进位
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            if (head == null) {
                head = new ListNode(sum % 10);
                p = head;
            } else {
                p.next = new ListNode(sum % 10);
                p = p.next;
            }
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            carry = sum / 10;
            l2 = l2.next;
        }
        if(carry > 0)
            p.next = new ListNode(carry);
        return head;



}
}

/**
 * @Author szl
 * @Date 2021/6/8 16:55
 * @Description 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead, q = dummyHead.next;
        for (int i = 0; i < left - 1; i++) {
            p = p.next;
            q = q.next;
        }
        System.out.println(p.val);
        System.out.println(q.val);
        for (int i = left; i < right; i++) {
            ListNode removed = q.next;
            q.next = q.next.next;
            removed.next = p.next;
            p.next = removed;
        }
        return dummyHead.next;
//        if (head == null || head.next == null || left == right)
//            return head;
//        int count = 1;
//        ListNode rHead = head, tail = head;
//        while (count < right) {
//            if (count < left)
//                rHead = rHead.next;
//            tail = tail.next;
//            count++;
//        }
////        System.out.println(rHead.val);
////        System.out.println(tail.val);
//        if (!(tail.next == null && rHead == head))
//            head.next = tail;
//        ListNode curr = rHead.next, pre = rHead, p, last;
//        System.out.println(rHead.val);
//        last = tail.next;
////        System.out.println(tail.val);
//        pre.next = last;
//        while (curr != last) {
//            System.out.println(curr.val);
//            System.out.println(pre.val);
//            p = curr.next;
//            curr.next = pre;
//            pre = curr;
//            curr = p;
//        }
//        if (rHead == head) {
//            System.out.println("等于");
//            return pre;
//        } else {
//            System.out.println("不等于");
//            return head;
//        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 1; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        p.next = null;
        ReverseLinkedListII reverseLinkedListII = new ReverseLinkedListII();
        ListNode res = reverseLinkedListII.reverseBetween(head, 1, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}


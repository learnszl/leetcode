/**
 * @Author szl
 * @Date 2021/6/10 10:41
 * @Description 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 * 返回同样按升序排列的结果链表。
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode p = dummyHead, q = head;
        boolean flag = false;
        while (q.next != null) {
            if (q.next.val == q.val) {
                flag = true;
                q.next = q.next.next;
            } else {
                if (flag) {
                    q = q.next;
                    p.next = q;
                    flag = false;
                } else {
                    p = p.next;
                    q = q.next;
                }
            }
        }
        if (flag) {
            p.next = null;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 1; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        p.next = new ListNode(5);
        p = p.next;
        p.next = new ListNode(6);
        p = p.next;
        p.next = new ListNode(6);
        p = p.next;
        p.next = null;
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedListII();
        ListNode res = removeDuplicatesFromSortedList.deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

/**
 * @Author szl
 * @Date 2021/6/10 10:01
 * @Description 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == p.val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 1; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
//        p.next = new ListNode(5);
//        p = p.next;
        p.next = null;
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode res = removeDuplicatesFromSortedList.deleteDuplicates(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

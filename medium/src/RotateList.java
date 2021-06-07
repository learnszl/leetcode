/**
 * @Author szl
 * @Date 2021/6/4 17:44
 * @Description 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * 例：输入：head = [1,2,3,4,5], k = 2
 * 输出：[4,5,1,2,3]
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null)
            return head;
        int count = 1;
        ListNode p = head, cur = head;
        ListNode q = new ListNode(0);
        q.next = head;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        int position = count - k % count;
        if (position == count)
            return head;
        while (position > 0) {
            q = q.next;
            position--;
        }
        head = q.next;
        q.next = null;
        p.next = cur;
        return head;
    }
}

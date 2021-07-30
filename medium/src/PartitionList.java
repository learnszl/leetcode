/**
 * @Author szl
 * @Date 2021/7/30 9:57
 * @Description 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode s = smallHead, b = bigHead;
        while (head != null) {
            if (head.val < x) {
                s.next = new ListNode(head.val);
                s = s.next;
            } else {
                b.next = new ListNode(head.val);
                b = b.next;
            }
            head = head.next;
        }
        s.next = bigHead.next;
        return smallHead.next;
    }
}

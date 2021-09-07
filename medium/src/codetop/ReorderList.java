package codetop;

import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/9/7 15:44
 * @Description 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *  L0 → L1 → … → Ln-1 → Ln 
 * 请将其重新排列后变为：
 * L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next.next == null)
            return;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head, q = head;
        while (q != null) {
            if (q.next != null)
                q = q.next.next;
            else
                break;
            p = p.next;
        }
        q = p;
        while (p.next != null) {
            stack.push(p.next);
            p = p.next;
        }
        q.next = null;
        ListNode pre = head, tail = head.next;
        while (!stack.isEmpty()) {
            ListNode r = stack.pop();
            r.next = tail;
            pre.next = r;
            pre = tail;
            tail = tail.next;
        }
    }
}

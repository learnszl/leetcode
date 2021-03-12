/**
 * @Author szl
 * @Date 2021/3/12 14:56
 * @Description
 */
public class RemoveNthFromEnd {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {//没加头结点
        if (head.next == null) {
            return null;
        }
        ListNode p = head, q = head;
        boolean flag = false;
        while (n > 0) {
            if (q.next != null) {
                q = q.next;
                n--;
            } else {
                flag = true;
                break;
            }
        }
        if (flag) {
            head = head.next;
            return head;
        } else {
            while (q.next != null) {
                p = p.next;
                q = q.next;
            }
            ListNode del = p.next;
            if (del.next == null)
                p.next = null;
            else {
                p.next = del.next;
                del.next = null;
            }
        }
        return head;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode node = new ListNode(0, head);
        ListNode p = node, q = node;
        while (n > 0) {
            q = q.next;
            n--;
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        ListNode del = p.next;
        if (del.next == null)
            p.next = null;
        else if (del == head)
            head = head.next;
        else {
            p.next = del.next;
            del.next = null;
        }
        return head;
    }
}


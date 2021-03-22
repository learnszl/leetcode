import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/3/22 10:19
 * @Description
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = new ListNode(-1);
        ListNode res = temp;
        ListNode q = head;
        for (int i = 0; i < length / k; i++) {
            int count = 0;
            while (count < k) {
                stack.push(q);
                q = q.next;
                count++;
            }
            while (!stack.isEmpty()) {
                temp.next = stack.peek();
                stack.pop();
                temp = temp.next;
            }
        }
        temp.next = q;
        return res.next;
    }
}

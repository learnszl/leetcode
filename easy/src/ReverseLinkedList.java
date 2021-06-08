import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author szl
 * @Date 2021/6/7 11:18
 * @Description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ArrayList<Integer> value = new ArrayList<>();
        while (head != null) {
            value.add(head.val);
            head = head.next;
        }
        Collections.reverse(value);
        int index = 0;
        ListNode p = new ListNode(value.get(index));
        ListNode res = p;
        index++;
        while (index < value.size()) {
            p.next = new ListNode(value.get(index));
            p = p.next;
            index++;
        }
        return res;
    }

    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head.next, pre = head, p;
        pre.next = null;
        while (curr != null) {
            p = curr.next;
            curr.next = pre;
            pre = curr;
            curr = p;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i = 1; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        p.next = null;
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode res = reverseLinkedList.reverseList2(head);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

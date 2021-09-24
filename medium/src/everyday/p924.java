package everyday;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/9/24 15:44
 * @Description 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，
 * 可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 */
public class p924 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null)
            return null;
        Node p = head;
        Stack<Node> nodes = new Stack<>();
        while (true) {
            if (p.child != null) {
                if (p.next != null)
                    nodes.add(p.next);
                Node q = p.child;
                p.next = q;
                q.prev = p;
                p.child = null;
            }
            if (p.next != null) {
                p = p.next;
            } else if (!nodes.isEmpty()) {
                Node q = nodes.pop();
                p.next = q;
                q.prev = p;
            } else
                return head;
        }
    }

    public Node flatten1(Node head) {
        if (head == null)
            return null;
        Queue<Node> nodes = new ArrayDeque<>();
        helper(head, nodes);
        Node dummyNode = new Node();
        Node p = dummyNode;
        while (!nodes.isEmpty()) {
            Node curr = nodes.poll();
            curr.next = null;
            curr.child = null;
            curr.prev = null;
            p.next = curr;
            curr.prev = p;
            p = p.next;
        }
        dummyNode.next.prev = null;
        return dummyNode.next;
    }


    private void helper(Node head, Queue<Node> stack) {
        if (head == null)
            return;
        stack.offer(head);
        helper(head.child, stack);
        helper(head.next, stack);
    }
}

package everyday;

import codetop.ListNode;


/**
 * @Author szl
 * @Date 2021/9/22 10:29
 * @Description 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
 * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
 * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
 * 返回一个由上述 k 部分组成的数组。
 * 输入：head = [1,2,3], k = 5
 * 输出：[[1],[2],[3],[],[]]
 * 解释：
 * 第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
 * 最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
 */
public class p922 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int total = 0;
        ListNode p = head, q = head;
        while (p != null) {
            p = p.next;
            total++;
        }
        p = head;
        int extra = total % k;
        int average = total / k;
        ListNode[] res = new ListNode[k];
        int i = 0;
        while (q != null) {
            if (extra > 0) {
                for (int j = 0; j < average; j++) {
                    q = q.next;
                }
            } else {
                for (int j = 0; j < average - 1; j++) {
                    q = q.next;
                }
            }
            if (q == null)
                break;
            else {
                res[i] = p;
                p = q.next;
                q.next = null;
                q = p;
                i++;
                extra--;
            }
        }
        for (int j = i; j < k; j++) {
            res[j] = null;
        }
        return res;
    }
}

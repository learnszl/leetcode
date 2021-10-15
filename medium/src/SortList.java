import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Author szl
 * @Date 2021/8/25 11:09
 * @Description 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> value = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            value.add(p.val);
            p = p.next;
        }
        value.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        p = head;
        int i = 0;
        while (p != null) {
            p.val = value.get(i);
            i++;
            p = p.next;
        }
        return head;
    }
}

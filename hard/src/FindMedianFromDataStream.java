import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author szl
 * @Date 2021/8/27 22:05
 * @Description 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，[2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 */
public class FindMedianFromDataStream {
    PriorityQueue<Integer> small = new PriorityQueue<>();
    PriorityQueue<Integer> large = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });

    public FindMedianFromDataStream() {
    }

    public void addNum(int num) {
        large.add(num);
        small.add(large.poll());
        if (large.size() < small.size())
            large.add(small.poll());
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() + small.peek()) / 2.0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> large = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        large.add(1);
        large.add(2);
        large.add(2);
        System.out.println(large);
        System.out.println(large.peek());
        large.poll();
        System.out.println(large.peek());
    }
}

package codetop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author szl
 * @Date 2021/10/11 10:47
 * @Description 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if (k == 1)
            return nums;
        int len = nums.length - k + 1;
        int[] res = new int[len];
        PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            heap.offer(new int[]{nums[i],i});
        }
        res[0] = heap.peek()[0];
        for (int i = k; i < nums.length; i++) {
            heap.offer(new int[]{nums[i],i});
            while (heap.peek()[1] <= i - k )
                heap.poll();
            res[i - k + 1] = heap.peek()[0];
        }
        return res;
    }
//    public int[] maxSlidingWindow1(int[] nums, int k) {
//        if (k == 1)
//            return nums;
//        int[] res = new int[nums.length - k + 1];
//        LinkedList<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < k; i++) {
//            queue.addFirst(i);
//        }
//        return
//
//
//    }
    

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
//        Arrays.sort(a, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//               return o2 - o1;
//            }
//        });
//        System.out.println(Arrays.toString(a));

        SlidingWindowMaximum slw = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(slw.maxSlidingWindow(a,3)));
    }
}

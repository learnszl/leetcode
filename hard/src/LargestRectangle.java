import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/4/15 10:36
 * @Description 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * 示例:
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class LargestRectangle {
    public static int largestRectangleArea(int[] heights) {//暴力超时
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            if (min > res)
                res = min;
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[j] < min)
                    min = heights[j];
                int temp = (j - i + 1) * min;
                if (temp > res)
                    res = temp;
            }
        }
        return res;
    }

    //    public static int largestRectangleArea1(int[] heights) {
//        int n = heights.length;
//        if(n == 0)
//            return 0;
//        int[] dp = new int[n];
//        dp[0] = heights[0];
//        for (int i = 1; i < n; i++) {
//
//
//        }
//
//    }
    public static int largestRectangleArea1(int[] heights) {//单调栈直接压入值错误，会导致无法清楚计算边界
        int res = 0;
        Stack<Integer> s = new Stack<>();
//        s.push(heights[0]);
        int[] newH = new int[heights.length + 1];
        System.arraycopy(heights, 0, newH, 0, heights.length);
        newH[heights.length] = 0;
        for (int i = 0; i < newH.length; i++) {
            int length = 0;
            while (!s.isEmpty() && s.peek() > newH[i]) {
                length++;
                res = Math.max(res, s.peek() * length);
//                System.out.println(res);
                s.pop();
            }
            s.push(newH[i]);
        }
        return res;
    }

    public static int largestRectangleArea2(int[] heights) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        int[] newH = new int[n + 2];
        System.arraycopy(heights, 0, newH, 1, n);
        for (int i = 0; i < newH.length; i++) {
            while (!s.isEmpty() && newH[s.peek()] > newH[i]) {
                int curr = s.pop();
                res = Math.max(res, (i - s.peek() - 1) * newH[curr]);
            }
            s.push(i);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(largestRectangleArea2(new int[]{2, 1, 2}));
    }
}

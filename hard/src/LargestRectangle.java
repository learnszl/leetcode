
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


    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{1}));
    }
}

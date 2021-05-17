import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/5/17 9:57
 * @Description
 */
public class TrappingRainWater {
    public static int trap(int[] height) {//暴力
        int n = height.length;
        if (n == 0)
            return 0;
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int max_left = height[i], max_right = height[i];
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left)
                    max_left = height[j];
            }
            for (int j = i + 1; j < n; j++) {
                if (height[j] > max_right)
                    max_right = height[j];
            }
            res = res + Math.min(max_left, max_right) - height[i];
        }
        return res;
    }

    public static int trap1(int[] height) {
        int n = height.length, res = 0;
        if(n == 0)
            return 0;
        int[] max_left = new int[n];
        int[] max_right = new int[n];
        max_left[0] = height[0];
        for (int i = 1; i < n - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i]);
        }
        max_right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            res = res + Math.min(max_left[i], max_right[i]) - height[i];
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(trap1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}

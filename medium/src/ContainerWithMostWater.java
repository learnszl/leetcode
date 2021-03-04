/**
 * @Author szl
 * @Date 2021/3/4 20:58
 * @Description
 */
public class ContainerWithMostWater {
    public static int containerWithMostWater(int[] height) {//超时
        int ans = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = (j - i) * Math.min(height[i], height[j]);
                if (temp > ans)
                    ans = temp;

            }
        }
        return ans;
    }

    public static int containerWithMostWater1(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int temp = (j - i) * (height[i] <= height[j] ? height[i++] : height[j--]);
            if (temp > ans)
                ans = temp;
        }
        return ans;

    }


    public static void main(String[] args) {
        System.out.println(ContainerWithMostWater.containerWithMostWater1(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

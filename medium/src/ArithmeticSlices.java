import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/8/10 9:56
 * @Description 如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
 * 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
 * <p>
 * 子数组 是数组中的一个连续序列。
 */
public class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] nums) {
        int res = 0, n = nums.length;
        if (n < 3)
            return res;
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int sub = nums[i] - nums[i - 1];
            int len = 2;
            for (int j = i + 1; j < n; j++) {
                int curr = nums[j] - nums[j - 1];
                if (curr != sub)
                    break;
                len++;
            }
            i += len - 2;
            if (len >= 3)
                num.add(len);
        }
        for (Integer integer : num) {
            int temp = integer - 2;
            res += temp * (temp + 1) / 2;
        }
        return res;
    }

    public static int numberOfArithmeticSlices1(int[] nums) {
        int n = nums.length, res = 0;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            dp[i] = (nums[i] - nums[i - 1]) == (nums[i - 1] - nums[i - 2]) ? dp[i - 1] + 1 : 0;
        }
        for (int d : dp)
            res += d;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices1(new int[]{1, 2, 3, 4, 7, 8, 9}));
    }
}
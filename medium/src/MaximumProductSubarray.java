/**
 * @Author szl
 * @Date 2021/5/14 10:36
 * @Description 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {//暴力
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > res)
                res = nums[i];
            int imax = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                imax *= nums[j];
                if (imax > res)
                    res = imax;
            }
        }
        return res;
    }
    public static int maxProduct1(int[] nums) {
        int res = Integer.MIN_VALUE, max = 1, min = 1;
        for (int num : nums) {
            if (num < 0) {
                int temp = min;
                min = max;
                max = temp;
            }
            max = Math.max(max * num, num);
            min = Math.min(min * num, num);
            res = Math.max(res, max);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(maxProduct1(new int[]{2, 3, -3, 2, -6}));
    }
}

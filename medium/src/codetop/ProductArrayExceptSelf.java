package codetop;

import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/9/15 15:28
 * @Description 给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，
 * 其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
//        int[] right = new int[n];
//        left[0] = 1;
//        right[n - 1] = 1;
//        for (int i = 1; i < n; i++) {
//            left[i] = left[i - 1] * nums[i - 1];
//            right[n - i - 1] = right[n - i] * nums[n - i];
//        }
//        for (int i = 0; i < n; i++) {
//            left[i] *= right[i];
//        }
        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int right_mul = 1;
        for (int i = n - 1; i >= 0; i--) {
            left[i] *= right_mul;
            right_mul *= nums[i];
        }
        return left;
    }

    public static void main(String[] args) {
        ProductArrayExceptSelf pae = new ProductArrayExceptSelf();
        System.out.println(Arrays.toString(pae.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}

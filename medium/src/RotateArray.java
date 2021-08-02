import java.util.Arrays;
import java.util.Collections;

/**
 * @Author szl
 * @Date 2021/8/2 15:42
 * @Description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * * 进阶：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] res = new int[n];
        System.arraycopy(nums, 0, res, k, n - k);
        System.arraycopy(nums, n - k, res, 0, k);
        System.arraycopy(res, 0, nums, 0, n);
    }

    // O(1)
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

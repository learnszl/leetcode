package everyday;

/**
 * @Author szl
 * @Date 2021/9/15 14:39
 * @Description 峰值元素是指其值严格大于左右相邻值的元素。
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2。
 */
public class p915 {
    public int findPeakElement(int[] nums) {//o(n)
        int n = nums.length;
        if (n == 1)
            return 0;
        if (nums[0] > nums[1])
            return 0;
        if (nums[n - 1] > nums[n - 2])
            return n - 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        }
        return 0;
    }

    public int findPeakElement1(int[] nums) {//O(log(n))
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r + l) >> 1;
            if (nums[mid] < nums[mid + 1])
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }
}


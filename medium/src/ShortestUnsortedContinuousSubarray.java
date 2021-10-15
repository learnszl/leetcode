import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/8/23 20:18
 * @Description 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */
public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] sorted = Arrays.copyOfRange(nums, 0, n);
        Arrays.sort(sorted);
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == sorted[i])
                l++;
            else
                break;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[r] == sorted[i])
                r--;
            else
                break;
        }
        return r > l ? r - l + 1 : 0;
    }

    public static int findUnsortedSubarray1(int[] nums) {
        int n = nums.length;
        int max = nums[0], min = nums[n - 1], l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[n - 1 - i]);
            if (nums[i] < max)
                l = i;
            if (nums[n - 1 - i] > min)
                r = n - 1 - i;
        }
        return l - r + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}

/**
 * @Author szl
 * @Date 2021/10/13 10:54
 * @Description 给你一个只包含正整数的非空数组 nums 。请你判断是否可以将这个数组分割成两个子集，
 * 使得两个子集的元素和相等。
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0, len = nums.length;
        for (int num : nums) sum += num;
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + 1);
            }
        }
        return dp[target] > 0;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1, 2, 2, 1}));
    }
}

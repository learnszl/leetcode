
/**
 * @Author szl
 * @Date 2021/8/19 10:11
 * @Description 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 */
public class TargetSum {
    int res = 0;

    /**
     * @param nums   数组
     * @param target 目标和
     * @return 种类（回溯）
     */

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        backtrack(nums, target, n, 0);
        return res;
    }

    /**
     * @param nums   数组
     * @param target 目标和
     * @return 种类(dp)
     */

    public int findTargetSumWays1(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int sub = sum - target;
        if (sub % 2 != 0 || sub < 0)
            return 0;
        int half = sub / 2;
        int[] dp = new int[half + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = half; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[half];
    }


    private void backtrack(int[] nums, int target, int n, int index) {
        if (index == n) {
            if (target == 0)
                res++;
            return;
        }
        backtrack(nums, target - nums[index], n, index + 1);
        backtrack(nums, target + nums[index], n, index + 1);
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(targetSum.findTargetSumWays1(new int[]{1, 1, 1, 1, 1}, 3));
    }
}

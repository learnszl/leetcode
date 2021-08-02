/**
 * @Author szl
 * @Date 2021/8/2 21:13
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 */
public class HouseRobberII {
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(robCommon(nums, 0, n - 1), robCommon(nums, 1, n));
    }

    public static int robCommon(int[] nums, int start, int end) {
        int n = end - start;
        if (n == 0)
            return nums[start];
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        int curr;
        for (int i = start + 2; i < end; i++) {
            curr = Math.max(second, first + nums[i]);
            first = second;
            second = curr;
        }
        return second;
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{0}));
    }
}

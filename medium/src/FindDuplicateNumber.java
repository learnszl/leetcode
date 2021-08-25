/**
 * @Author szl
 * @Date 2021/8/24 10:20
 * @Description 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 */
public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                int res = 0;
                while (nums[res] != nums[slow]) {
                    slow = nums[slow];
                    res = nums[res];
                }
                return nums[res];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1, 3, 4, 4, 2}));
    }
}

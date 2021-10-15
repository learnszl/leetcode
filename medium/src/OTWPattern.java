import java.util.HashMap;
import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/8/13 11:34
 * @Description 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列
 * 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 */
public class OTWPattern {
    public static boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        s.push(nums[0]);
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            while (!s.isEmpty() && nums[i] <= s.peek()) {
                flag = true;
                s.pop();
            }
            s.push(nums[i]);
            if (s.size() != 1 && flag)
                return true;
            else
                flag = false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{1, 2, 3, 4}));
    }
}

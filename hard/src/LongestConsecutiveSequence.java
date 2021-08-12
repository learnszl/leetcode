import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author szl
 * @Date 2021/5/8 12:45
 * @Description 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutiveSequence(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int res = 0, temp = 1;
        System.out.println(Arrays.toString(nums));
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1)
                temp++;
            else if( nums[i] == nums[i - 1])
                continue;
            else {
                if (res < temp)
                    res = temp;
                temp = 1;
            }
        }
        return Math.max(res, temp);
    }
    public static int longestConsecutiveSequence1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        int res = 0;
        for (int num : set) {
            int temp = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(num + 1)) {
                    num++;
                    temp++;
                }
            }
            if (res < temp)
                res = temp;
        }
        return res;
    }




    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequence1(new int[]{}));
    }
}

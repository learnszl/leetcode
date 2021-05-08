import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author szl
 * @Date 2021/5/8 12:45
 * @Description
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

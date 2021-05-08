import java.util.Arrays;

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

    public static void main(String[] args) {
        System.out.println(longestConsecutiveSequence(new int[]{0,1,1,2}));
    }
}

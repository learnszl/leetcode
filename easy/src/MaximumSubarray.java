/**
 * @Author szl
 * @Date 2021/3/29 18:49
 * @Description
 */
public class MaximumSubarray {
    public static int maximumSubarray(int[] nums) {
        int pre = 0, res = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            if (pre > res)
                res = pre;
//            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximumSubarray(new int[]{-1}));
    }
}

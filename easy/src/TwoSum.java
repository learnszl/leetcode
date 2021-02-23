

/**
 * @Author szl
 * @Date 2021/2/23 13:54
 * @Description
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){
        int[]  ans = new int[2];
        int N = nums.length;
        for (int i = 0; i < N-1 ; i++) {
            for (int j = i+1; j < N; j++) {
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                }

            }

        }
        return ans;


    }
}

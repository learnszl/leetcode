import java.util.HashMap;

/**
 * @Author szl
 * @Date 2021/2/23 13:54
 * @Description
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target){//暴力破解
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
    public static int[] twoSum1(int[] nums, int target){//哈希表
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            if (hashMap.containsKey(target - nums[i]))
                return new int[]{hashMap.get(target-nums[i]), i};
            hashMap.put(nums[i],i);
            
        }
        return new int[0];

    }

    public static void main(String[] args) {
        int[] nums = {1,5,5,28};
        for (int value: twoSum1(nums,10)){
            System.out.println(value);
        }
    }

}

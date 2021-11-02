package codetop;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author szl
 * @Date 2021/11/2 10:20
 * @Description
 */
public class p1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{i, map.get(target - nums[i])};
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        p1 p1 = new p1();
        System.out.println(Arrays.toString(p1.twoSum(new int[]{3, 2, 4}, 6)));
    }
}

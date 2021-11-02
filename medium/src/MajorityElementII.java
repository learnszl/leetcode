import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/10/22 11:12
 * @Description
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // List<Integer> res = new ArrayList<>();
        // int n = nums.length / 3;
        // for(int num:nums){
        //     map.put(num,map.getOrDefault(num,0) + 1);
        //     if(map.get(num) > n){
        //         if(!res.contains(num))
        //         res.add(num);
        //     }
        //     if(res.size() > 1)
        //         break;
        // }
        // return res;
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            res.add(nums[0]);
            return res;
        }
        int maj1 = 0, count1 = 0;
        int maj2 = 0, count2 = 0;
        for (int num : nums) {
            if (count1 != 0 && maj1 == num)
                count1++;
            else if (count2 != 0 && maj2 == num)
                count2++;
            else if (count1 == 0) {
                maj1 = num;
                count1++;
            } else if (count2 == 0) {
                maj2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        if (maj1 == maj2) {
            if (helper(nums, maj1))
                res.add(maj1);
        } else {
            if (helper(nums, maj1))
                res.add(maj1);
            if (helper(nums, maj2))
                res.add(maj2);
        }
        return res;
    }

    private boolean helper(int[] nums, int target) {
        int count = 0, n = nums.length;
        for (int num : nums) {
            if (num == target)
                count++;
            if (count > n / 3)
                return true;
        }
        return false;
    }
}

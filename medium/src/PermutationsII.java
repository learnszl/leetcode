import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/3/23 15:48
 * @Description
 */
public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrace(res, new ArrayList<>(), 0, nums, used);
        return res;
    }

    public static void backtrace(List<List<Integer>> res, ArrayList<Integer> temp, int index, int[] nums, boolean[] used) {
        if (index == nums.length && !res.contains(temp)) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    temp.add(nums[i]);
                    used[i] = true;
                    backtrace(res, temp, index + 1, nums, used);
                    used[i] = false;
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 3}));
    }
}

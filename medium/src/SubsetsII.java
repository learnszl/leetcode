import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/4/17 19:02
 * @Description 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        ArrayList<Integer> first = new ArrayList<>();
        first.add(nums[0]);
        res.add(first);
        int layerLen = 1;
        for (int i = 1; i < nums.length; i++) {
            int len = res.size();
            int start = nums[i] == nums[i - 1] ? len - layerLen : 0;
            layerLen = 0;
            for (int j = start; j < len; j++) {
                layerLen++;
                ArrayList<Integer> temp = new ArrayList<>(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1, 2, 2}));
    }
}


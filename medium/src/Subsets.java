import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/4/14 10:44
 * @Description 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        System.out.println(res.size());
        for (int num : nums) {
            int len = res.size();
            for (int j = 0; j < len; j++) {
                ArrayList<Integer> list = new ArrayList<>(res.get(j));
                list.add(num);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}

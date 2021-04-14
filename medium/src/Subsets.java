import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/4/14 10:44
 * @Description
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
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

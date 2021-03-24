import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/3/24 14:54
 * @Description
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int N = candidates.length;
//        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), 0, N, candidates, target);
        return res;
    }

    public static void backtrace(List<List<Integer>> res, ArrayList<Integer> temp, int index, int len, int[] candidates, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < len; i++) {
            temp.add(candidates[i]);
            backtrace(res, temp, i, len, candidates, target - candidates[i]);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}

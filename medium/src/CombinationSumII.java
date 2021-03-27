import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/3/24 16:34
 * @Description
 */
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int N = candidates.length;
//        Arrays.sort(candidates);
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[N];
        backtrace(res, new ArrayList<>(), 0, N,candidates, target, used);
        return res;
    }

    public static void backtrace(List<List<Integer>> res, ArrayList<Integer> temp, int index, int len, int[] candidates, int target, boolean[] used) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < len; i++) {
            if (!used[i]) {
                temp.add(candidates[i]);
                used[i] = true;
                backtrace(res, temp, index + 1, len, candidates, target - candidates[i], used);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }
}

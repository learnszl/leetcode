import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/4/13 9:55
 * @Description
 */
public class Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), n, k, 1);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, ArrayList<Integer> temp, int n, int k, int index) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
        } else {
            for (int i = index; i <= n; i++) {
                temp.add(i);
                System.out.println("递归之前 =>" + temp);
                backtrack(res, temp, n, k, i + 1);
                temp.remove(temp.size() - 1);
                System.out.println("递归之后 =>" + temp);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }
}

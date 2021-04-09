import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/4/8 16:48
 * @Description
 */
public class PermutationSequence {

    public static String getPermutation(int n, int k) {
        ArrayList<String> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        backtrack(res, new StringBuffer(), n, used, 1);
        return res.get(k - 1);
    }

    public static void backtrack(List<String> res, StringBuffer temp, int n, boolean[] used, int count) {
        if (temp.length() == n)
            res.add(temp.toString());
        else {
            for (int i = 1; i <= n; i++) {
                if (!used[i - 1]) {
                    temp.append(i);
                    used[i - 1] = true;
                    backtrack(res, temp, n, used, count + 1);
                    used[i - 1] = false;
                    temp.deleteCharAt(temp.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 9));
    }
}

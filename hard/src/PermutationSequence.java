import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/4/8 16:48
 * @Description
 */
public class PermutationSequence {
    private int count = 0;
    private final List<String> list = new ArrayList<>();

    public String getPermutation(int n, int k) {
        List<String> res = new ArrayList<>();
        boolean[] used = new boolean[n];
        backtrack(res, new StringBuffer(), n, used, k);
        System.out.println(res.size());
        System.out.println(list.size());
        System.out.println(list);
        return res.get(0);
    }

    public void backtrack(List<String> res, StringBuffer temp, int n, boolean[] used, int k) {
        if (temp.length() == n) {
            list.add(temp.toString());
            count++;
            if (count == k) {
                res.add(temp.toString());
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (count >= k)
                    continue;
                if (!used[i - 1]) {
                    temp.append(i);
                    used[i - 1] = true;
                    backtrack(res, temp, n, used, k);
                    used[i - 1] = false;
                    temp.deleteCharAt(temp.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(4, 9));
    }
}

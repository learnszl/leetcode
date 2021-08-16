import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/8/16 10:25
 * @Description 假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组
 * 使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。
 * 条件：
 * 第 i 位的数字能被 i 整除
 * i 能被第 i 位上的数字整除
 * 现在给定一个整数 N，请问可以构造多少个优美的排列？
 */
public class BeautifulArrangement {
    int res = 0;

    public int countArrangement(int n) {
        boolean[] used = new boolean[n];
        backtrack(n, 1, used);
        return res;
    }

    private void backtrack(int n, int index, boolean[] used) {
        if (index == n + 1)
            res++;
        for (int i = 1; i <= n; i++) {
            if ((i % index == 0 || index % i == 0) && !used[i - 1]) {
//                temp.add(i);
                used[i - 1] = true;
                backtrack(n, index + 1, used);
                used[i - 1] = false;
//                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        System.out.println(beautifulArrangement.countArrangement(10));
    }
}

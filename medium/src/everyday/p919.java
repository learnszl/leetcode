package everyday;

/**
 * @Author szl
 * @Date 2021/9/19 15:59
 * @Description 最初记事本上只有一个字符 'A' 。你每次可以对这个记事本进行两种操作：
 * Copy All（复制全部）：复制这个记事本中的所有字符（不允许仅复制部分字符）。
 * Paste（粘贴）：粘贴 上一次 复制的字符。
 * 给你一个数字 n ，你需要使用最少的操作次数，在记事本上输出 恰好 n 个 'A' 。返回能够打印出 n 个 'A' 的最少操作次数。
 * 输入：3
 * 输出：3
 * 解释：
 * 最初, 只有一个字符 'A'。
 * 第 1 步, 使用 Copy All 操作。
 * 第 2 步, 使用 Paste 操作来获得 'AA'。
 * 第 3 步, 使用 Paste 操作来获得 'AAA'。
 */
public class p919 {
    int res = Integer.MAX_VALUE;

    /**
     * @param n 字符数
     * @return dfs
     */

    public int minSteps(int n) {
        if (n == 1)
            return 0;
        dfs(n, 1, 1, 1);
        return res;
    }

    private void dfs(int n, int temp, int copy, int curr) {
        if (curr > n)
            return;
        if (curr == n) {
            res = Math.min(res, temp);
        }
        dfs(n, temp + 1, copy, curr + copy);//粘贴
        dfs(n, temp + 2, curr, curr * 2);//复制粘贴
    }

    /**
     * @param n 字符数
     * @return 分解质因数
     */
    public int minSteps1(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            while (n % i == 0) {
                res += i;
                n /= i;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        p919 p919 = new p919();
        System.out.println(p919.minSteps(6));
    }
}

/**
 * @Author szl
 * @Date 2021/6/11 11:33
 * @Description 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class UniqueBinarySearchTrees {
    public static int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
    /*
    解法二：卡塔兰数
    dp[0] = 1, dp[n+1] = 2 * (2 * n + 1)/(n + 2) * dp[n]
     */

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}

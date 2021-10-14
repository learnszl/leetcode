import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/8/4 15:36
 * @Description 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int num_m = 0, num_n = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    num_m++;
                else
                    num_n++;
            }
            for (int i = m; i >= num_m; i--) {
                for (int j = n; j >= num_n; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - num_m][j - num_n] + 1);
                }
            }
        }
        return dp[m][n];
    }
}

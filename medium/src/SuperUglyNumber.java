import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/8/9 22:23
 * @Description 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 * 输入：n = 12, primes = [2,7,13,19]
 * 输出：32
 * 解释：给定长度为 4 的质数数组 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 */
public class SuperUglyNumber {
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] index = new int[len];
        Arrays.fill(index, 1);
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = dp[index[0]] * primes[0];
            for (int j = 1; j < len; j++) {
                min = Math.min(min, dp[index[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < len; j++) {
                if (dp[i] == dp[index[j]] * primes[j])
                    index[j]++;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthSuperUglyNumber(12,new int[]{2,7,13,19}));
    }
}

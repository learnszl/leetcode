import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/10/13 11:39
 * @Description
 */
public class packageProblem {
    public int package01(int[] weight, int[] value, int limit) {
        int n = value.length;
        int[][] dp = new int[n][limit + 1];
        for (int i = 1; i <= limit; i++) {
            dp[0][i] = i >= weight[0] ? value[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= limit; j++) {
                if (j >= weight[i])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][limit];
    }

    public int package01_spaceOpt(int[] weight, int[] value, int limit) {
        int n = value.length;
        int[] dp = new int[limit + 1];
//        for (int i = 1; i <= limit; i++) {
//            dp[i] = i >= weight[0] ? value[0] : 0;
//        }
        for (int i = 0; i < n; i++) {
            for (int j = limit; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[limit];
    }


    public static void main(String[] args) {
        packageProblem packageProblem = new packageProblem();
        System.out.println(packageProblem.package01(new int[]{1, 3, 5, 2, 5}, new int[]{4, 2, 4, 6, 2}, 8));
        System.out.println(packageProblem.package01_spaceOpt(new int[]{1, 3, 5, 2, 5}, new int[]{4, 2, 4, 6, 2}, 8));
    }
}

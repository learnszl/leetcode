import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/5/6 9:31
 * @Description
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j <= i; j++) {
                if (j == i)
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
        }
        int res = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            if (dp[n - 1][j] < res)
                res = dp[n - 1][j];
        }
        System.out.println(Arrays.deepToString(dp));
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(1));
        lists.add(Arrays.asList(1, 2));
        lists.add(Arrays.asList(3, 4, 5));
        lists.add(Arrays.asList(8, 10, 1, 2));
        System.out.println(minimumTotal(lists));
    }
}

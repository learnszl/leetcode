/**
 * @Author szl
 * @Date 2021/5/19 18:45
 * @Description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {
    static int res;

    public static int uniquePaths(int m, int n) {
        dfs(m, n, 1, 1);
        return res;
    }

    private static void dfs(int m, int n, int startRow, int startColumn) {
        if (startRow == m && startColumn == n) {
            res = res + 1;
        }
        if (startRow < m) {
//            System.out.println(startRow + "。。。 " + startColumn);
            dfs(m, n, startRow + 1, startColumn);
        }
        if (startColumn < n) {
            dfs(m, n, startRow, startColumn + 1);
        }
    }

    public static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths1(19, 13));
    }
}

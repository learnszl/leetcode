/**
 * @Author szl
 * @Date 2021/8/3 10:55
 * @Description 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] new_matrix = new int[row][column];
        int[][] dp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    res = Math.max(res, dp[i][j]);
                }
                if (j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    res = Math.max(res, dp[i][j]);
                }
                new_matrix[i][j] = matrix[i][j] - '0';
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (new_matrix[i][j] == 0 || dp[i - 1][j - 1] == 0 || dp[i][j - 1] == 0 || dp[i - 1][j] == 0) {
                    dp[i][j] = new_matrix[i][j];
                } else {
                    int len = (int) Math.sqrt(dp[i - 1][j - 1]), k, m;
                    for (k = 1; k <= len; k++) {
                        if (new_matrix[i][j - k] == 0)
                            break;
                    }
                    for (m = 1; m <= len; m++) {
                        if (new_matrix[i - m][j] == 0)
                            break;
                    }
                    int temp = Math.min(m, k);
                    dp[i][j] = temp * temp;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}

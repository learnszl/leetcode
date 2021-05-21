import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/5/21 10:05
 * @Description 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 */
public class SpiralMatrixII {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int u = 0, d = n - 1, l = 0, r = n - 1;
        int value = 1;
        while (true) {
            for (int i = l; i <= r; i++) {
                res[u][i] = value++;
            }
            if (++u > d)
                break;
            for (int i = u; i <= d; i++) {
                res[i][r] = value++;
            }
            if (--r < l)
                break;
            for (int i = r; i >= l; i--) {
                res[d][i] = value++;
            }
            if (--d < u)
                break;
            for (int i = d; i >= u; i--) {
                res[i][l] = value++;
            }
            if (++l > r)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(4)));
    }
}

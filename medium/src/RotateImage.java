/**
 * @Author szl
 * @Date 2021/6/4 16:11
 * @Description 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class RotateImage {
    public void rotateImage(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            {
                for (int k = 0; k < n; k++) {
                    temp[k][j] = matrix[i][k];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.arraycopy(temp[i], 0, matrix[i], 0, n);
        }
    }
}



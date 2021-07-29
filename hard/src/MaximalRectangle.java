import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/7/26 15:46
 * @Description 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int res = 0, column = matrix[0].length;
        int[][] new_matrix = new int[matrix.length][column];
        for (int i = 0; i < column; i++) {
            new_matrix[0][i] = matrix[0][i] - '0';
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < column; j++) {
                new_matrix[i][j] = matrix[i][j] == '0' ? 0 : new_matrix[i - 1][j] + matrix[i][j] - '0';
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] row = new int[column + 2];
            System.arraycopy(new_matrix[i], 0, row, 1, column);
            System.out.println();
            res = Math.max(res, layerMaxRectangle(row));
        }
        return res;
    }

    private static int layerMaxRectangle(int[] row) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < row.length; i++) {
            while (!s.isEmpty() && row[s.peek()] > row[i]) {
                int curr = s.pop();
                res = Math.max(res, (i - s.peek() - 1) * row[curr]);
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][]{{'1', '0', '1'}, {'1', '1', '1'}}));
    }
}

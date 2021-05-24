import java.util.HashSet;

/**
 * @Author szl
 * @Date 2021/5/24 10:24
 * @Description 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */
public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> column = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    column.add(j);
                }
            }
        }
//        for (int i : row) {
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[i][j] = 0;
//            }
//        }
//        for (int j : column) {
//            for (int i = 0; i < matrix.length; i++) {
//                matrix[i][j] = 0;
//            }
//        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || column.contains(j))
                    matrix[i][j] = 0;
            }
        }
    }
}



import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/5/19 10:18
 * @Description 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        while (true) {
//            if (u > d)
//                break;
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            if (++u > d)
                break;
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            if (--r < l)
                break;
            for (int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }
            if (--d < u)
                break;
            for (int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }
            if (++l > r)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{2, 5, 8}, {4, 5, 6}}));
    }
}

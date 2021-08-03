/**
 * @Author szl
 * @Date 2021/7/30 14:56
 * @Description 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 */
public class MaxPointsOnLine {
    public static int maxPoints(int[][] points) {
        int res = 1;
        int row = points.length;
        for (int i = 0; i < row; i++) {
            int k = points[i][1] / points[i][0];
            int temp = 1;
            for (int j = i + 1; j < row; j++) {
                if (k == points[j][1] / points[j][0])
                    temp++;
                else
                    break;
            }
            res = Math.max(res, temp);
            if (res >= row - i)
                break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{0,0},{1, 1}, {2, 2}, {3, 3}}));
    }
}

package everyday;

import java.util.HashMap;

/**
 * @Author szl
 * @Date 2021/9/13 10:06
 * @Description 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。
 * 回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 */
public class p913 {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int[] p : points) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int[] temp : points) {
                int distance = (p[0] - temp[0]) * (p[0] - temp[0]) + (p[1] - temp[1]) * (p[1] - temp[1]);
                map.put(distance, map.getOrDefault(distance, 0) + 1);
            }
            for (Integer key : map.keySet()) {
                int num = map.get(key);
                res += num * (num - 1);
            }
        }
        return res;
    }
}
    
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/4/2 14:24
 * @Description
 */
public class InsertInterval {
    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        int N = intervals.length;
        if (N == 0)
            return new int[][]{newInterval};
        ArrayList<int[]> res = new ArrayList<>();
        boolean flag = false;
        for (int[] interval : intervals) {
            if (interval[0] > newInterval[1]) {
                if (!flag) {
                    res.add(newInterval);
                    flag = true;
                }
                res.add(interval);
            } else if (newInterval[0] > interval[1])
                res.add(interval);
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }
        if (!flag)
            res.add(newInterval);
//        for (int[] re : res) System.out.println(Arrays.toString(re));
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(insertInterval(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5})));
    }
}

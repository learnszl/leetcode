import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author szl
 * @Date 2021/4/2 11:30
 * @Description
 */
public class MergeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] temp = intervals[0];
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > temp[1]) {
                res.add(temp);
                temp = intervals[i];
            } else {
                temp[1] = Math.max(intervals[i][1], temp[1]);
            }
        }
        res.add(temp);
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeIntervals(new int[][]{{1, 3}, {2, 6}, {8, 10}, {8, 15}})));
    }
}

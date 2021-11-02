package everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/10/29 10:00
 * @Description 给你一个整数数组 distance 。
 * 从 X-Y 平面上的点(0,0)开始，先向北移动 distance[0] 米，
 * 然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，
 * 持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false
 */
public class p1029 {

    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length, i = 0, x = 0, y = 0;
        HashSet<List<Integer>> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(0);
        set.add(list);
        while (i < n) {
            if (i % 4 == 0) {
                for (int j = 0; j < distance[i]; j++) {
                    y++;
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(x);
                    pos.add(y);
                    if (!set.contains(pos))
                        set.add(pos);
                    else
                        return true;
                }
            } else if (i % 4 == 1) {
                for (int j = 0; j < distance[i]; j++) {
                    x--;
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(x);
                    pos.add(y);
                    if (!set.contains(pos))
                        set.add(pos);
                    else
                        return true;
                }
            } else if (i % 4 == 2) {
                for (int j = 0; j < distance[i]; j++) {
                    y--;
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(x);
                    pos.add(y);
                    if (!set.contains(pos))
                        set.add(pos);
                    else
                        return true;
                }
            } else {
                for (int j = 0; j < distance[i]; j++) {
                    x++;
                    ArrayList<Integer> pos = new ArrayList<>();
                    pos.add(x);
                    pos.add(y);
                    if (!set.contains(pos))
                        set.add(pos);
                    else
                        return true;
                }
            }
            i++;
        }
        return false;
    }


    public static void main(String[] args) {
        HashSet<int[]> set = new HashSet<>();
        int[] a = {0, 0};
        System.out.println(Arrays.hashCode(a));
        set.add(a);
        int[] b= {0, 0};
        System.out.println(Arrays.hashCode(b));
        System.out.println(Arrays.equals(a,b));
        System.out.println(set.contains(b));
        p1029 p1029 = new p1029();
        System.out.println(p1029.isSelfCrossing(new int[]{1, 2, 3, 4}));
    }
}

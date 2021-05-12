import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/5/12 17:34
 * @Description 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1])
                left[i] = left[i - 1] + 1;
        }
        int count = left[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                right[i] = right[i + 1] + 1;
            count += Math.max(left[i], right[i]);
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 2, 3, 3, 3, 1}));
    }
//    public static int candy(int[] ratings) {
//        int n = ratings.length;
//        if (n == 0)
//            return 0;
//        ArrayList<Integer> pos = new ArrayList<>();
//
//        int min = ratings[0];
//        for (int i = 1; i < n; i++) {
//            if (ratings[i] < min) {
//                min = ratings[i];
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if(min == ratings[i])
//                pos.add(i);
//        }
//        int res = countMin(ratings,pos.get(0));
//        for (int i = 1; i < pos.size(); i++) {
//            int temp = countMin(ratings,pos.get(i));
//            if(temp > res)
//                res = temp;
//
//        }
//        return res;
//
//
//    }
//    public static int countMin(int[] ratings, int position) {
//        int n = ratings.length;
//        int[] res = new int[n];
//        res[position] = 1;
//        int left = position, right = position;
//        while (left > 0) {
//            if (ratings[left - 1] > ratings[left])
//                res[left - 1] = res[left] + 1;
//            else {
//                if (res[left] > 1)
//                    res[left - 1] = res[left] - 1;
//                else
//                    res[left - 1] = 1;
//            }
//            left--;
//        }
//        while (right < n - 1) {
//            if (ratings[right + 1] > ratings[right])
//                res[right + 1] = res[right] + 1;
//            else {
//                if (res[right] > 1)
//                    res[right + 1] = res[right] - 1;
//                else
//                    res[right + 1] = 1;
//            }
//            right++;
//        }
//        int candy = 0;
//        for (int r : res
//        ) {
//            candy += r;
//        }
//        return candy;
//
//    }
}

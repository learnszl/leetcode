import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author szl
 * @Date 2021/3/10 18:39
 * @Description
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {//暴力超时
        int N = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triples = new ArrayList<>();
                        System.out.println(triples);
                        triples.add(nums[i]);
                        triples.add(nums[j]);
                        triples.add(nums[k]);
                        Collections.sort(triples);
                        res.add(triples);
                        System.out.println(res);
                    }
                }
            }
        }
        HashSet<List<Integer>> set = new HashSet<>(res);
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSum1(int[] nums) {//通过但很慢
        int N = nums.length;
        if (N < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        int left, right;
        for (int i = 1; i < N - 1; i++) {
            left = 0;
            right = N - 1;
            while (left < i && right > i) {
                int target = nums[left] + nums[right] + nums[i];
                if (target > 0)
                    right--;
                else if (target < 0)
                    left++;
                else {
                    ArrayList<Integer> triples = new ArrayList<>();
                    triples.add(nums[left]);
                    triples.add(nums[i]);
                    triples.add(nums[right]);
                    right--;
                    left++;
                    res.add(triples);
                }
            }
        }
        return new ArrayList<>(res);
    }


    public static void main(String[] args) {
        System.out.println(ThreeSum.threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}

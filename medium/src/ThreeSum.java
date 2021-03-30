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
//                        System.out.println(triples);
                        triples.add(nums[i]);
                        triples.add(nums[j]);
                        triples.add(nums[k]);
                        Collections.sort(triples);
                        res.add(triples);
//                        System.out.println(res);
                    }
                }
            }
        }
        HashSet<List<Integer>> set = new HashSet<>(res);
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSum1(int[] nums) {//虽然是双指针，但是通过hashset去重，通过但很慢,可先排序
        int N = nums.length;
        if (N < 3)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int left, right;
        for (int i = 0; i < N; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            left = i + 1;
            right = N - 1;
            while (left < right) {
                if (nums[i] > 0)
                    break;
                int target = nums[left] + nums[right] + nums[i];
                if (target == 0) {
                    ArrayList<Integer> triples = new ArrayList<>();
                    triples.add(nums[i]);
                    triples.add(nums[left]);
                    triples.add(nums[right]);
                    right--;
                    left++;
                    res.add(triples);
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                    while (left < right && nums[right + 1] == nums[right])
                        right--;
                }
//                if (left > 1 && nums[left] == nums[left - 1]) {
//                    left++;
//                    continue;
//                }
//                if (right < N - 1 && nums[right] == nums[right + 1]) {
//                    right--;
//                    continue;
//                }
                else if (target > 0)
                    right--;
                else
                    left++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(threeSum1(new int[]{0, 0, 0, 0}));
    }
}

import java.util.*;

/**
 * @Author szl
 * @Date 2021/10/28 15:21
 * @Description 给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到2 的幂，返回 true；否则，返回 false。
 */
public class ReorderedPowerOfTwo {
    public boolean reorderedPowerOf2(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }
        boolean[] used = new boolean[nums.size()];
        Collections.sort(nums);
        return dfs(nums, 0, 0, used);
    }

    public boolean reorderedPowerOf21(int n) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= 30; i++) {
            System.out.println(1 << i);
            set.add(countBits(1 << i));
        }
        return set.contains(countBits(n));
    }

    private String countBits(int n) {
        int[] bits = new int[10];
        while (n > 0) {
            bits[n % 10]++;
            n /= 10;
        }
        return Arrays.toString(bits);
    }


    private boolean dfs(List<Integer> nums, int index, int temp, boolean[] used) {
        if (index == nums.size()) {
            // System.out.println(temp);
            return helper(temp);
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == 0 && temp == 0 || used[i] || (i != 0 && nums.get(i) == nums.get(i - 1) && !used[i - 1]))
                continue;
            used[i] = true;
            if (dfs(nums, index + 1, temp * 10 + nums.get(i), used))
                return true;
            used[i] = false;
        }
        return false;
    }

    private boolean helper(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        ReorderedPowerOfTwo re = new ReorderedPowerOfTwo();
        System.out.println(re.reorderedPowerOf21(5));
        System.out.println(re.reorderedPowerOf2(5));
    }
}

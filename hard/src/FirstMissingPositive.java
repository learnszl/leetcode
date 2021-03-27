import java.util.HashSet;

/**
 * @Author szl
 * @Date 2021/3/25 21:13
 * @Description
 */
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        System.out.println(set);
        System.out.println(set.contains(1));
        for (int i = 1; i < set.size() + 1; i++) {
            if(!set.contains(i)) {
                System.out.println(i);
                return i;
            }
        }
        return set.size() + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{2}));
    }
}

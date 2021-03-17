import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/3/17 11:31
 * @Description
 */
public class FindFirstAndLastPosition {
    public static int[] findFirstAndLastPosition(int[] nums, int target) {
        int i = 0, length = 0, res = 0;
        for (; i < nums.length; i++) {
            if (nums[i] == target) {
                length++;
                res = i;
            }
        }
        if (length != 0)
            return new int[]{res - length + 1, res};
        else
            return new int[]{-1, 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findFirstAndLastPosition(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/4/12 9:46
 * @Description
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        int N = nums.length;
        if (N < 2)
            return;
        int left = 0, right = N - 1, i = 0;
        while (i < right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 1)
                i++;
            else {
                swap(nums, i, right);
                right--;
            }
        }
    }


    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

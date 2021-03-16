
/**
 * @Author szl
 * @Date 2021/3/16 17:28
 * @Description
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        int N = nums.length, i = nums.length - 1;
        for (; i > 0; --i) {
            if (nums[i] > nums[i - 1])
                break;
        }
        System.out.println(i);
        if (i == 0) {
            reverse(nums, 0, N - 1);
        } else {
            for (int j = N - 1; j > i - 1; j--) {
                if (nums[j] > nums[i - 1]) {
                    swap(nums, i - 1, j);
                    reverse(nums, i, N - 1);
                    break;
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1};
        for (int value : nums) {
            System.out.print(value + " ");
        }
        System.out.println();
        nextPermutation(nums);
        for (int value : nums) {
            System.out.print(value + " ");
        }
    }
}

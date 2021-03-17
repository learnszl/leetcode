import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/3/17 11:31
 * @Description
 */
public class FindFirstAndLastPosition {
    public static int[] findFirstAndLastPosition(int[] nums, int target) {//暴力
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

    public static int[] findFirstAndLastPosition1(int[] nums, int target) {
        int n = nums.length;
        if (n == 0)
            return new int[]{-1, -1};
        int key = binarySearch(nums, target);
        System.out.println(key);
        if (key == -1)
            return new int[]{-1, -1};
        int start = key - 1, end = key + 1;
        for (; start >= 0; start--) {
            if (nums[start] != nums[key])
                break;
        }
        for (; end < n; end++) {
            if (nums[end] != nums[key])
                break;
        }
        return new int[]{start + 1, end - 1};
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(findFirstAndLastPosition1(new int[]{1, 4, 5, 6, 23, 23}, 23)));
//        System.out.println(Arrays.toString(findFirstAndLastPosition(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}

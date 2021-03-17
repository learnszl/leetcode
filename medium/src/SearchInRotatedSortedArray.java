/**
 * @Author szl
 * @Date 2021/3/17 10:52
 * @Description
 */
public class SearchInRotatedSortedArray {
    public static int searchInRotatedSortedArray(int[] nums, int target) {//复杂度：N
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int searchInRotatedSortedArray1(int[] nums, int target) {//复杂度：log(N)
        int n = nums.length;
        if (n == 0)
            return -1;
        if (n == 1)
            return nums[0] == target ? 0 : -1;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[0] <= nums[mid]) {
                if (nums[mid] >= target && nums[0] <= target) {
                    right = mid - 1;
                } else
                    left = mid + 1;
            } else {
                if (nums[mid] <= target && nums[n - 1] >= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(searchInRotatedSortedArray1(new int[]{1, 2, 3, 4, 5, 7}, 5));
    }
}

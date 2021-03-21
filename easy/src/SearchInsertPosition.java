/**
 * @Author szl
 * @Date 2021/3/21 22:09
 * @Description
 */
public class SearchInsertPosition {
    public static int searchInsertPosition(int[] nums, int target) {
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                break;
            } else if (nums[i] > target)
                break;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 5));
    }
}

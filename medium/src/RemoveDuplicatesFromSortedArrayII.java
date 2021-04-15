/**
 * @Author szl
 * @Date 2021/4/15 9:55
 * @Description
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static int removeDuplicatesFromSortedArrayII(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicatesFromSortedArrayII(new int[]{1,1,1,2,2,2,3,3,4}));
    }
}

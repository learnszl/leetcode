
/**
 * @Author szl
 * @Date 2021/3/12 22:11
 * @Description
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicatesFromSortedArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j])
                i++;
            nums[i] = nums[j];
        }
        return i + 1;
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicatesFromSortedArray(new int[]{1, 1, 2, 2, 3, 4, 5}));
    }
}


/**
 * @Author szl
 * @Date 2021/3/12 22:11
 * @Description
 */
public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicatesFromSortedArray(int[] nums) {
//        if (nums.length == 0)
//            return 0;
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[i] != nums[j])
//                i++;
//            nums[i] = nums[j];
//        }
//        return i + 1;
        int i = 0;
        for (int num : nums) {
            if (i < 1 || num > nums[i - 1]) {
                nums[i] = num;
                i++;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicatesFromSortedArray(new int[]{1, 1, 2, 2, 3, 4, 5}));
    }
}

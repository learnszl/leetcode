/**
 * @Author szl
 * @Date 2021/3/18 12:04
 * @Description
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            System.out.println("i:" + i + "  " + "j:" + j);
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{1, 3, 2, 2, 3, 4, 5}, 3));
    }
}

/**
 * @Author szl
 * @Date 2021/9/4 21:14
 * @Description 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int count = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else
                count--;
            if (count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}

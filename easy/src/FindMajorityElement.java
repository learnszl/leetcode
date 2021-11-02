/**
 * @Author szl
 * @Date 2021/10/22 10:49
 * @Description 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。
 * 请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 */
public class FindMajorityElement {
    public int majorityElement(int[] nums) {
        int maj = 0, count = 0;
        for (int num : nums) {
            if (count != 0 && maj == num)
                count++;
            else if (count == 0) {
                maj = num;
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for (int num : nums) {
            if (num == maj)
                count++;
            if (count > nums.length / 2)
                return maj;
        }
        return -1;
    }
}

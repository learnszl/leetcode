import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/4/23 11:02
 * @Description
 */
public class MergeSortedArray {
    public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {//面向题解的编程
        if (n == 0)
            return;
        int j = 0;
        for (int i = 0; i < m + n; i++) {
            if (j == n)
                break;
            if (nums1[i] <= nums2[j])
                continue;
            if (m + j - i >= 0) System.arraycopy(nums1, i, nums1, i + 1, m + j - i);
//            for (int k = m + j; k > i; k--) {
//                nums1[k] = nums1[k - 1];
//            }
            nums1[i] = nums2[j];
            j++;
        }
        for (int i = j; i < n; i++) {
            nums1[m + i] = nums2[j];
            j++;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        mergeSortedArray(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println(Arrays.toString(nums1));
    }
}

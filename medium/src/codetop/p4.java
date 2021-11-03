package codetop;

public class p4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int len = m + n;
        int left = 0, right = 0;
        int s1 = 0, s2 = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (s1 < m && (s2 >= n || nums1[s1] < nums2[s2])) {
                right = nums1[s1++];
            } else
                right = nums2[s2++];
        }
        if (len % 2 == 0)
            return (left + right) / 2.0;
        else
            return right;
    }
}

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/2/24 20:22
 * @Description
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int ans = 0;
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                list.add(nums1[i++]);
            }
            else if (nums1[i] > nums2[j]) {
                list.add(nums2[j++]);
            }
            else{
                list.add(nums1[i++]);
                list.add(nums2[j++]);
            }
        }
//        System.out.println("****" + i + "***" + j);
        if(i == nums1.length){
            for (int k = j; k < nums2.length; k++) {
                list.add(nums2[k]);

            }
        }
        if(j == nums2.length){
            for (int k = i; k < nums1.length; k++) {
                list.add(nums1[k]);

            }
        }
        if(list.size() % 2 != 0)
            return list.get(list.size() / 2);
        else
            return (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) / 2.0;



    }

    public static void main(String[] args) {
        double N = 3 / 2;
        System.out.println(N);
        int[] a = {1,3,4,5};
        int[] b = {2,4,6,7};
        System.out.println(findMedianSortedArrays(a,b));


    }

}


package codetop;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author szl
 * @Date 2021/8/31 17:10
 * @Description 给你一个整数数组 nums，请你将该数组升序排列。
 */
public class SortAnArray {
    public int[] quickSort(int[] nums) {
        randomQuickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public int[] heapSort(int[] nums) {
        int len = nums.length;
        buildHeap(nums);
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
        return nums;
    }

    public int[] mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(nums, l, m);
            mergeSort(nums, m + 1, r);
            merge(nums, l, m, r);
        }
    }

    private void merge(int[] nums, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] LM = new int[len1];
        int[] MR = new int[len2];
        if (len1 >= 0) System.arraycopy(nums, l, LM, 0, len1);
        if (len2 >= 0) System.arraycopy(nums, m + 1, MR, 0, len2);
        int i = 0, j = 0, k = l;
        while (i < len1 && j < len2) {
            if (LM[i] <= MR[j]) {
                nums[k] = LM[i];
                i++;
            } else {
                nums[k] = MR[j];
                j++;
            }
            k++;
        }
        while (i < len1) {
            nums[k] = LM[i];
            k++;
            i++;
        }
        while (j < len2) {
            nums[k] = MR[j];
            k++;
            j++;
        }
    }

    private void buildHeap(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapify(nums, nums.length, i);
        }
    }

    private void heapify(int[] nums, int n, int i) {
        int root = i, left = 2 * i + 1, right = 2 * i + 2;
        if (left < n && nums[left] > nums[root])
            root = left;
        if (right < n && nums[right] > nums[root])
            root = right;
        if (root != i) {
            swap(nums, root, i);
            heapify(nums, n, root);
        }
    }

    private void randomQuickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = randomPartition(nums, l, r);
            randomQuickSort(nums, l, pos - 1);
            randomQuickSort(nums, pos + 1, r);
        }
    }

    private int randomPartition(int[] nums, int l, int r) {
        int pivotPos = new Random().nextInt(r - l + 1) + l;
        swap(nums, pivotPos, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        SortAnArray sort = new SortAnArray();
        System.out.println(Arrays.toString(sort.quickSort(new int[]{4, 2, 6, 26, 7, 278, 76, 43})));
        System.out.println(Arrays.toString(sort.heapSort(new int[]{4, 2, 6, 26, 7, 278, 76, 43})));
        System.out.println(Arrays.toString(sort.mergeSort(new int[]{4, 2, 6, 26, 7, 278, 76, 43})));
    }
}

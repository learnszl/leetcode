package codetop;

import java.util.Random;

/**
 * @Author szl
 * @Date 2021/9/1 20:30
 * @Description 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return quickSelect(nums, 0, len - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int l, int r, int index) {
        int pos = RandomPartition(nums, l, r);
        if (pos == index)
            return nums[pos];
        else if (pos > index) {
            return quickSelect(nums, l, pos - 1, index);
        } else {
            return quickSelect(nums, pos + 1, r, index);
        }
    }

    private int RandomPartition(int[] nums, int l, int r) {
        int pos = new Random().nextInt(r - l + 1) + l;
        swap(nums, pos, r);
        return partition(nums, l, r);
    }

    private int partition(int[] nums, int l, int r) {
        int value = nums[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (nums[j] <= value) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length, j = k;
        buildHeap(nums);
        for (int i = len - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
            if (--j == 0)
                break;
        }
        return nums[len - k];
    }

    private void buildHeap(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--)
            heapify(nums, nums.length, i);
    }

    private void heapify(int[] nums, int n, int i) {
        int large = i;
        int l = i * 2 + 1, r = i * 2 + 2;
        if (l < n && nums[l] > nums[large])
            large = l;
        if (r < n && nums[r] > nums[large])
            large = r;
        if (large != i) {
            swap(nums, i, large);
            heapify(nums, n, large);
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthLargestElement kth = new KthLargestElement();
        System.out.println(kth.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(kth.findKthLargest1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}

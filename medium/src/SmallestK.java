import java.util.Arrays;
import java.util.Random;

/**
 * @Author szl
 * @Date 2021/9/3 10:08
 * @Description 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0)
            return new int[]{};
        int[] res = new int[k];
        int pos = findSmallK(arr, k, 0, arr.length - 1);
        System.out.println(pos);
        System.out.println(Arrays.toString(arr));
        if (pos >= 0) System.arraycopy(arr, 0, res, 0, pos);
        return res;
    }

    private int findSmallK(int[] arr, int k, int l, int r) {
        int pos = randomPartition(arr, l, r);
        if (pos == k)
            return pos;
        else if (pos > k)
            return findSmallK(arr, k, l, pos - 1);
        else
            return findSmallK(arr, k, pos + 1, r);
    }

    private int randomPartition(int[] arr, int l, int r) {
        int pos = new Random().nextInt(r - l + 1) + l;
        swap(arr, pos, r);
        return partition(arr, l, r);
    }


    private int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SmallestK s = new SmallestK();
        System.out.println(Arrays.toString(s.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4)));
    }
}

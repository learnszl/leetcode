import java.sql.SQLOutput;

/**
 * @Author szl
 * @Date 2021/8/29 11:08
 * @Description
 */
public class SumAllOddLengthSubArrays {
    public static int sumOddLengthSubArrays(int[] arr) {
        int res = 0, len = 1;
        while (len <= arr.length) {
            int i = 0;
            while (i <= arr.length - len) {
                for (int j = 0; j < len; j++) {
                    res += arr[i + j];
                }
                i++;
            }
            len += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sumOddLengthSubArrays(new int[]{1, 4}));
    }
}

/**
 * @Author szl
 * @Date 2021/4/26 9:48
 * @Description
 */
public class SqrtX {
    public static int mySqrt(int x) {
        int left = 0, right = x, res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147483647));
    }
}

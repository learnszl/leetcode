package everyday;

/**
 * @Author szl
 * @Date 2021/9/23 10:37
 * @Description 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 */
public class p923 {
    public boolean isPowerOfThree(int n) {
        if (n < 1)
            return false;
        if (n == 1)
            return true;
        return n % 3 == 0 && isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        p923 p923 = new p923();
        System.out.println(p923.isPowerOfThree(6));
    }
}

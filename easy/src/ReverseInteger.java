import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/3/2 16:10
 * @Description
 */
public class ReverseInteger {
    public static int reverseInteger(int x) {
        ArrayList<Integer> integers = new ArrayList<>();
        long ans = 0;
        long k = 1;
        int absx = Math.abs(x);
        while (absx > 0) {
            integers.add(absx % 10);
            absx /= 10;

        }
        for (int i = integers.size() - 1; i >= 0; i--) {
            ans += integers.get(i) * k;
            k *= 10;
        }
        if (x < 0)
            ans = -ans;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return 0;
        else
            return ((int) ans);

    }

    public static void main(String[] args) {
        System.out.println(ReverseInteger.reverseInteger(1534236469));
    }
}

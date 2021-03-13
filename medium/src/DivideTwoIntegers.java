/**
 * @Author szl
 * @Date 2021/3/13 21:57
 * @Description
 */
public class DivideTwoIntegers {
    public static int divideTwoIntegers(int dividend, int divisor) {//脑瘫方法，贼慢
        if (divisor == 1) {
            return dividend;
        }
        // 当除数为-1且被除数为Integer.MIN_VALUE时，将会溢出，返回Integer.MAX_VALUE
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        boolean negative = (dividend ^ divisor) < 0;
        int res = 0;
        long dd = Math.abs((long) dividend);
        long ds = Math.abs((long) divisor);
        while (dd >= ds) {
            dd -= ds;
            res++;
        }
        return negative ? -res : res;
    }
    public static int divideTwoIntegers1(int dividend, int divisor) {
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(divideTwoIntegers(-2147483648, -2));
    }
}

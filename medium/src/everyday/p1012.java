package everyday;

/**
 * @Author szl
 * @Date 2021/10/12 10:35
 * @Description 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 */
public class p1012 {
    public int divide(int dividend, int divisor) {
        if (divisor == 1)
            return dividend;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean negative = (dividend ^ divisor) < 0;
        int res = 0;
//        使用long
//        long did = Math.abs((long) dividend);
//        long dis = Math.abs((long) divisor);
//        while (did >= dis) {
//            long temp = dis, mul = 1;
//            while (temp << 1 <= did) {
//                temp <<= 1;
//                mul <<= 1;
//            }
//            did -= temp;
//            res += mul;
//        }
        if (dividend > 0)
            dividend = -dividend;
        if (divisor > 0)
            divisor = -divisor;
        int threshold = Integer.MIN_VALUE >> 1;
        while (dividend <= divisor) {
            int temp = divisor, mul = 1;
            while (temp >= threshold && temp << 1 >= dividend) {
                temp <<= 1;
                mul <<= 1;
            }
            dividend -= temp;
            res += mul;
        }
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        p1012 p1012 = new p1012();
        System.out.println(p1012.divide(Integer.MIN_VALUE, 1));
    }
}

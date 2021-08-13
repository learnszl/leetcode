/**
 * @Author szl
 * @Date 2021/8/13 10:12
 * @Description 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 * 输入：n = 13
 * 输出：6
 */
public class NumberOfDigitOne {
    public static int countDigitOne(int n) {
        int res = 0, d = 1;
        int high = n / 10, low = 0, curr = n % 10;
        while (high != 0 || curr != 0) {
//            System.out.println(curr);
//            System.out.println(low);
            if (curr == 0)
                res += high * d;
            else if (curr == 1)
                res += high * d + low + 1;
            else
                res += (high + 1) * d;
            low += curr * d;
            curr = high % 10;
            high = high / 10;
            d *= 10;
//            System.out.println(res);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }
}

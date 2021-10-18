package everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/10/18 12:28
 * @Description 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 */
public class p1018 {
    public int findComplement(int num) {
        List<Integer> nums = new ArrayList<>();
        while (num != 0) {
            nums.add(num % 2);
            num /= 2;
        }
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == 0)
                res += (int) Math.pow(2, i);
        }
        return res;
    }

    public int findComplement1(int num) {
        int highBit = 0;
        for (int i = 0; i < 31; i++) {
            if (num >= 1 << i)
                highBit = i;
            else
                break;
        }
        int res = highBit == 30 ? Integer.MAX_VALUE : (1 << (highBit + 1)) - 1;
        return num ^ res;
    }

    public static void main(String[] args) {
        System.out.println(1 << 2);
        p1018 p1018 = new p1018();
        System.out.println(p1018.findComplement1(5));
    }
}

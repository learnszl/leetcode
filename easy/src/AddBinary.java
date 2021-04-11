/**
 * @Author szl
 * @Date 2021/4/11 12:19
 * @Description
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        StringBuilder res = new StringBuilder();
        sa.reverse();
        sb.reverse();
        int i = 0, carry = 0;
        while (i < sa.length() || i < sb.length()) {
            int xa = i < sa.length() ? sa.charAt(i) - '0' : 0;
            int xb = i < sb.length() ? sb.charAt(i) - '0' : 0;
            res.append((xa + xb + carry) % 2);
            carry = (xa + xb + carry) / 2;
            i++;
        }
        if (carry != 0)
            res.append(carry);
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1", "1"));
    }
}

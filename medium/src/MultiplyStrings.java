/**
 * @Author szl
 * @Date 2021/3/31 14:41
 * @Description
 */
public class MultiplyStrings {
    public static String multiplyStrings(String num1, String num2) {//超时
        if (Integer.parseInt(num1) == 0 || Integer.parseInt(num2) == 0)
            return "0";
        String res = "";
        for (int i = 0; i < Integer.parseInt(num1); i++) {
            res = addStrings(res, num2);
        }
        return res;
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int x1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int x2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = x1 + x2 + carry;
            res.append(Integer.valueOf(temp % 10));
            carry = temp / 10;
            i--;
            j--;
        }
        if (carry != 0)
            res.append(Integer.valueOf(carry));
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(multiplyStrings("0", "0"));
    }
}

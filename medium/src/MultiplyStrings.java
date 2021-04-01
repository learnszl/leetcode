import java.util.ArrayList;

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

    public static String multiplyStrings1(String num1, String num2) {//可以通过但是很慢
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        int N = num1.length();
        ArrayList<String> list = new ArrayList<>();
        String res = "";
        for (int i = N - 1; i >= 0; i--) {
            int j = i;
            StringBuilder temp = new StringBuilder();
            for (int k = 0; k < num1.charAt(i) - '0'; k++) {
//                System.out.println((int) num1.charAt(i));
                temp = new StringBuilder(addStrings(temp.toString(), num2));
            }
            while (j < N - 1) {
                temp.append('0');
                j++;
            }
            list.add(temp.toString());
        }
//        System.out.println(list.size());
//        System.out.println(list);
        for (String s : list) {
            res = addStrings(res, s);
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
        System.out.println(multiplyStrings1("6913259244", "71103343"));
    }
}

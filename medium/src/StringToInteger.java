

/**
 * @Author szl
 * @Date 2021/3/3 15:29
 * @Description
 */
public class StringToInteger {
    public int stringToInteger(String s) {
        String s1 = s.trim();
        if (s1.length() == 0)
            return 0;
        int ans = 0;
        int position = 0;
        boolean isPositive = true;
        char c = s1.charAt(0);
        if (c == '-') {
            isPositive = false;

        }
        if (c == '+' || c == '-')
            position++;
        while (position < s1.length() && Character.isDigit(s1.charAt(position))) {
            int x = s1.charAt(position) - '0';
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && x > 7))
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            ans = ans * 10 + x;
            position++;
        }
        return isPositive ? ans : -ans;


    }

//    public int ret(double x, boolean flag) {
//        if (x > Integer.MAX_VALUE && flag)
//            return Integer.MAX_VALUE;
//        else if (x > Integer.MAX_VALUE)
//            return Integer.MIN_VALUE;
//        else
//            return (int) x;
//    }

    public static void main(String[] args) {
        StringToInteger stringToInteger = new StringToInteger();
        System.out.println(stringToInteger.stringToInteger("9223372036854775808"));
    }
}

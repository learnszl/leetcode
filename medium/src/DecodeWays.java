/**
 * @Author szl
 * @Date 2021/4/19 15:17
 * @Description
 */
public class DecodeWays {
//    public static int numDecoding(String s) {
//        if (s.charAt(0) == '0')
//            return 0;
//        int count = 0;
//        int count0 = 0;
//        for (int i = 0; i < s.length() - 1; i++) {
//            int x = s.charAt(i) - '0';
//            int y = s.charAt(i + 1) - '0';
//            if (x > 0 &&x < 3 && y < 7)
//                count++;
//            if ((x > 2 || x == 0) && y == 0) {
//                return 0;
//            }
//            if (y == 0) {
//                count0++;
//            }
//        }
//        int count2 = 0;
//        for (int i = 0; i < s.length() - 2; i++) {
//            if(s.charAt(i) != '0' && s.charAt(i+1) != '0' && s.charAt(i+2) == '0')
//                count2++;
//
//        }
//        return count + 1 - count0 - count2;
//    }

    public static int numDecoding(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
                    dp[i + 1] = dp[i - 1];
                else
                    return 0;
            } else {
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))
                    dp[i + 1] = dp[i] + dp[i - 1];
                else
                    dp[i + 1] = dp[i];
            }
        }
        return dp[s.length()];
    }


    public static void main(String[] args) {
        System.out.println(numDecoding("2201"));
    }
}

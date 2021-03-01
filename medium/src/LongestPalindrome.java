
/**
 * @Author szl
 * @Date 2021/2/25 20:57
 * @Description
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {//中心扩展算法
        int N = s.length();
        if (N < 2)
            return s;
        int start = 0;
        int end = 0;
        int len;
        for (int i = 0; i < N; i++) {
            int lenodd = expandCenter(s, i, i);
            int leneven = expandCenter(s, i, i + 1);
            len = Math.max(lenodd, leneven);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);


    }

    public int expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    public String longestPalindrome1(String s) {//动态规划
        int N = s.length();
        if (N < 2)
            return s;
        boolean[][] dp = new boolean[N][N];
        int start = 0;
        int maxlen = 1;
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;

                } else {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];

                }
                if (dp[i][j] && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    start = i;
                }
            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(start + " " + maxlen);
        return s.substring(start, start + maxlen);


    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome1("abbb"));
    }
}

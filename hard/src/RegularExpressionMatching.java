/**
 * @Author szl
 * @Date 2021/3/4 15:50
 * @Description 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class RegularExpressionMatching {
    public static boolean regularExpressionMatching(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 2; j <= m; j++) {
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                else if (p.charAt(j - 1) == '.' || (s.charAt(i - 1) == p.charAt(j - 1)))
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(regularExpressionMatching("ab", ".*"));
    }
}

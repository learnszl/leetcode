import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/5/18 10:26
 * @Description 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * <p>
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = true;
            else
                break;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("abcxmb", "abc*b"));
    }
}

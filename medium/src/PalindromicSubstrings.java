/**
 * @Author szl
 * @Date 2021/8/17 17:19
 * @Description 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 **/
public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        int len = s.length(), res = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = (j - i < 2 || dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                if (dp[i][j])
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }
}


import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/5/10 18:35
 * @Description 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。返回符合要求的 最少分割次数 。
 */
public class PalindromePartitioningII {
    public static int minCut(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (cs[i] != cs[j])
                    dp[i][j] = false;
                else {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
        int[] f = new int[n];
        for (int j = 0; j < n; j++) {
            if (dp[0][j])
                f[j] = 0;
            else {
                f[j] = f[j - 1] + 1;
                for (int i = 0; i < j; i++) {
                    if (dp[i][j])
                        f[j] = Math.min(f[j], f[i - 1] + 1);
                }
            }
        }
        return f[n - 1];
    }
//        int n = s.length();
//        boolean[][] dp = new boolean[n][n];
//        for (int j = 0; j < n; j++) {
//            for (int i = 0; i <= j; i++) {
//                if (s.charAt(i) != s.charAt(j))
//                    dp[i][j] = false;
//                else {
//                    if (j - i < 3)
//                        dp[i][j] = true;
//                    else
//                        dp[i][j] = dp[i + 1][j - 1];
//                }
//            }
//        }
//        ArrayList<String> res = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            res.add(s);
//        }
//        dfs(res, new ArrayList<>(), s, 0, n, dp);
//        return res.size() - 1;
//    }
//
//    private static void dfs(ArrayList<String> res, ArrayList<String> temp, String s, int index, int n, boolean[][] dp) {
//        if (index == n) {
//            if (temp.size() < res.size()) {
//                System.out.println(temp);
//                res.clear();
//                res.addAll(temp);
//            }
//        }
//        for (int i = index; i < n; i++) {
//            if (!dp[index][i])
//                continue;
//            temp.add(s.substring(index, i + 1));
//            if (temp.size() >= res.size()) {
//                temp.remove(temp.size() - 1);
//                return;
//            }
//            dfs(res, temp, s, i + 1, n, dp);
//            temp.remove(temp.size() - 1);
//        }
//    }


    public static void main(String[] args) {
        System.out.println(minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
    }
}



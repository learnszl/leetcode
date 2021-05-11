
import java.util.ArrayList;

import java.util.List;

/**
 * @Author szl
 * @Date 2021/5/10 9:58
 * @Description
 */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else {
                    if (j - i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i + 1][j - 1];
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0)
            return res;
        dfs(res, new ArrayList<>(), s, 0, n, dp);
        return res;
    }

    private static void dfs(List<List<String>> res, ArrayList<String> temp, String s, int index, int n, boolean[][] dp) {
        if (index == n) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = index; i < n; i++) {
            if (!dp[index][i])
                continue;
            temp.add(s.substring(index, i + 1));
            dfs(res, temp, s, i + 1, n, dp);
            temp.remove(temp.size() - 1);
        }
    }
//    private static boolean isPalindrome(String s, int left, int right) {
//        while (left < right) {
//            if (s.charAt(left) == s.charAt(right)) {
//                left++;
//                right--;
//            } else
//                return false;
//        }
//        return true;
//    }

    public static void main(String[] args) {
        System.out.println(partition("abab"));
    }
}

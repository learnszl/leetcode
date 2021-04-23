import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/4/22 15:03
 * @Description
 */
public class InterleavingString {
    boolean res = false;
    boolean[][] visited;

    public boolean isInterleave(String s1, String s2, String s3) {//回溯
        if (s1.length() + s2.length() != s3.length())
            return false;
        visited = new boolean[s1.length() + 1][s2.length() + 1];
        dfs(s1, s2, s3, 0, 0, 0);
        return res;
    }

    private void dfs(String s1, String s2, String s3, int index1, int index2, int index3) {
        if (index3 == s3.length()) {
            res = true;
            return;
        }
        if (res)
            return;
        if (visited[index1][index2]) {
            return;
        }
        visited[index1][index2] = true;
        if (index1 < s1.length() && s1.charAt(index1) == s3.charAt(index3)) {
            System.out.println("递归之前：" + index1 + " " + index2 + " " + index3);
            dfs(s1, s2, s3, index1 + 1, index2, index3 + 1);
            System.out.println("递归之后：" + index1 + " " + index2 + " " + index3);
        }
        if (res)
            return;
        if (index2 < s2.length() && s2.charAt(index2) == s3.charAt(index3)) {
            System.out.println("递归之前：" + index1 + " " + index2 + " " + index3);
            dfs(s1, s2, s3, index1, index2 + 1, index3 + 1);
            System.out.println("递归之后：" + index1 + " " + index2 + " " + index3);
        }
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j < len2 + 1; j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave1("aabcc", "dbbca", "aadbbcbcac"));
    }
}

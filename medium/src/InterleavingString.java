/**
 * @Author szl
 * @Date 2021/4/22 15:03
 * @Description
 */
public class InterleavingString {
    boolean res = false;
    boolean[][] visited;

    public boolean isInterleave(String s1, String s2, String s3) {
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

    public static void main(String[] args) {
        InterleavingString is = new InterleavingString();
        System.out.println(is.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
}

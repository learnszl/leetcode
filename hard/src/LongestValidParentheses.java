/**
 * @Author szl
 * @Date 2021/3/30 14:32
 * @Description
 */
public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        return Math.max(count(s, '('), count(new StringBuffer(s).reverse().toString(), ')'));
    }

    public static int count(String s, char c) {
        int left = 0, right = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                left++;
            else
                right++;
            if (right == left)
                res = Math.max(res, 2 * right);
            else if (right > left) {
                right = 0;
                left = 0;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));
    }
}

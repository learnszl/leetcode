import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/3/12 21:26
 * @Description
 */
public class GenerateParentheses {
    public static List<String> generateParentheses(int n) {
        ArrayList<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private static void backtrack(List<String> res, StringBuilder sb, int left, int right, int max) {
        if (sb.length() == max * 2) {
            res.add(sb.toString());
            return;
        }
        if (left < max) {
            sb.append('(');
            backtrack(res, sb, left + 1, right, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(')');
            backtrack(res, sb, left, right + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParentheses(3));
    }
}

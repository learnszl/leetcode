import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author szl
 * @Date 2021/8/26 11:10
 * @Description 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * 输入：s = "(a)())()"
 * 输出：["(a())()","(a)()()"]
 */
public class RemoveInvalidParentheses {
    List<String> res = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {
        int lr = 0, rr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                lr++;
            } else if (s.charAt(i) == ')') {
                if (lr == 0)
                    rr++;
                else
                    lr--;
            }
        }
        dfs(s, 0, 0, 0, lr, rr);
        return new ArrayList<>(res);
    }

    private void dfs(String s, int index, int lcount, int rcount, int lremove, int rremove) {
        if (lremove == 0 && rremove == 0) {
            if (isValid(s))
                res.add(s);
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if(i != index && s.charAt(i) == s.charAt(i-1))
                continue;
            if (rremove + lremove > s.length() - i)
                break;
            char c = s.charAt(i);
            String s1 = s.substring(0, i) + s.substring(i + 1);
            if (c == '(' && lremove > 0)
                dfs(s1, i, lcount, rcount, lremove - 1, rremove);
            if (c == ')' && rremove > 0)
                dfs(s1, i, lcount, rcount, lremove, rremove - 1);
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            else if (s.charAt(i) == ')') {
                count--;
                if (count < 0)
                    return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses re = new RemoveInvalidParentheses();
        System.out.println(re.removeInvalidParentheses("(r(()()("));
        System.out.println(re.isValid(""));
    }
}

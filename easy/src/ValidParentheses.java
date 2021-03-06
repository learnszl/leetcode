import java.util.HashMap;
import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/3/12 16:59
 * @Description
 */
public class ValidParentheses {
    public static boolean validParentheses(String s) {
        int N = s.length();
        if (N == 0 || N % 2 != 0)
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
//        StringBuilder left = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            if (left.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'))
//                return false;
//            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
//                left.append(s.charAt(i));
//            else {
//                if (map.get(s.charAt(i)) != left.charAt(left.length() - 1)) {
//                    break;
//                } else {
//                    left.deleteCharAt(left.length() - 1);
//                }
//            }
//        }
//        return left.isEmpty();//since 15 等于 left.length() == 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != map.get(ch))
                    return false;
                stack.pop();
            } else
                stack.push(ch);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParentheses("}{"));
    }
}

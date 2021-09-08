import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/9/7 16:42
 * @Description 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> value = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token))
                operator.push(token.charAt(0));
            else
                value.push(Integer.parseInt(token));
            while (!operator.isEmpty()) {
                char o = operator.pop();
                int v1 = value.pop();
                int v2 = value.pop();
                value.push(operator(v1, v2, o));
            }
        }
        return value.peek();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int operator(int v1, int v2, char o) {
        return switch (o) {
            case '*' -> v2 * v1;
            case '/' -> v2 / v1;
            case '+' -> v2 + v1;
            case '-' -> v2 - v1;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}

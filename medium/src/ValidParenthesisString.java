import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/9/12 15:09
 * @Description 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：
 * 任何左括号 ( 必须有相应的右括号 )。
 * 任何右括号 ) 必须有相应的左括号 ( 。
 * 左括号 x( 必须在对应的右括号之前 )。
 * * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 * 一个空字符串也被视为有效字符串。
 */
public class ValidParenthesisString {
    /**
     * @param s 给定字符串
     * @return 是否为有效的括号，该方法采用栈
     */
    public static boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left.push(i);
            else if (s.charAt(i) == '*')
                star.push(i);
            else {
                if (left.isEmpty()) {
                    if (star.isEmpty()) {
                        return false;
                    } else {
                        star.pop();
                    }
                } else {
                    left.pop();
                }
            }
        }
        while (!left.isEmpty()) {
            if (!star.isEmpty()) {
                if (left.pop() > star.pop())
                    return false;
            } else
                break;
        }
        return left.isEmpty();
    }

    public static boolean checkValidString1(String s) {
        int minCount = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                minCount++;
                maxCount++;
            } else if (s.charAt(i) == ')') {
                maxCount--;
                minCount = Math.max(0, minCount - 1);
            } else {
                maxCount++;
                minCount = Math.max(0, minCount - 1);
            }
            if (maxCount < 0)
                return false;
        }
        return minCount == 0;
    }


    public static void main(String[] args) {
        System.out.println(checkValidString("()()*"));
        System.out.println(checkValidString1("()()*"));
    }
}


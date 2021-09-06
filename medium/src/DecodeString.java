import java.util.Stack;

/**
 * @Author szl
 * @Date 2021/9/6 10:26
 * @Description 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 */
public class DecodeString {
    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (int i = charArray.length - 1; i >= 0; i--) {
            stack.push(charArray[i]);
            if (stack.peek() == '[') {
                stack.pop();
                StringBuilder temp = new StringBuilder();
                while (stack.peek() != ']') {
                    temp.append(stack.pop());
                }
                stack.pop();
                int turn = 0, j;
                for (j = 1; i - j >= 0; j++) {
//                    System.out.println(charArray[i-j]);
                    if (Character.isDigit(charArray[i - j])) {
                        turn += (charArray[i - j] - '0') * Math.pow(10, j - 1);
                    } else
                        break;
                }
                for (int k = 0; k < turn; k++) {
                    for (int l = temp.length() - 1; l >= 0; l--) {
                        stack.push(temp.charAt(l));
                    }
                }
                i = i - j + 1;
            }
//            System.out.println(stack);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(decodeString("3[a2[c]]"));
    }
}

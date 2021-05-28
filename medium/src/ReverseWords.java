import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/5/28 10:05
 * @Description 给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。
 * <p>
 * 说明：
 * 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
 * 翻转后单词间应当仅用一个空格分隔。
 * 翻转后的字符串中不应包含额外的空格。
 */
public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
//        for (String w :words)
//            System.out.println(w.length());
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty())
                res.append(words[i]).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "                hello            world             ";
        System.out.println(reverseWords(s));
    }
}

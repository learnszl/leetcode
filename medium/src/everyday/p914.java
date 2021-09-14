package everyday;

import java.util.Comparator;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/9/14 10:14
 * @Description 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，
 * 找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 */
public class p914 {
    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = o1.length(), len2 = o2.length();
                if (len1 != len2)
                    return len2 - len1;
                else
                    return o1.compareTo(o2);
            }
        });
        for (String value : dictionary) {
            if (isIn(s, value))
                return value;
        }
        return "";
    }

    private boolean isIn(String s, String p) {
        int i = 0, j = 0;
        while (i < s.length() && j < p.length()) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else
                i++;
        }
        return j == p.length();
    }
}

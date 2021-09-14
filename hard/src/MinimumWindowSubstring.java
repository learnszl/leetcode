import java.util.HashMap;

/**
 * @Author szl
 * @Date 2021/5/26 9:44
 * @Description 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 例：输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int begin = 0, end = 0, counter = map.size();
        int len = Integer.MAX_VALUE;
        int[] pos = new int[2];
        boolean flag = false;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            end++;
            while (counter == 0) {
                char temp = s.charAt(begin);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0)
                        counter++;
                }
                if (end - begin < len) {
                    flag = true;
                    pos[0] = begin;
                    pos[1] = end;
                    len = end - begin;
                }
                begin++;
            }
        }
        if (flag)
            return s.substring(pos[0], pos[1]);
        else
            return "";
    }

    public static void main(String[] args) {
        MinimumWindowSubstring mws = new MinimumWindowSubstring();
        System.out.println(mws.minWindow("ADOBECODEBANC", "ABC"));
    }
}

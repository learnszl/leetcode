package codetop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/9/13 10:58
 * @Description 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。
 * 不考虑答案输出的顺序。
 * 异位词 指字母相同，但排列不同的字符串。
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {//超时
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }
        for (int i = 0; i <= s.length() - p.length(); i++) {
            HashMap<Character, Integer> temp = new HashMap<>(map);
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (temp.containsKey(c)) {
                    if (temp.get(c) == 1)
                        temp.remove(c, 1);
                    else
                        temp.put(c, temp.get(c) - 1);
                    if (temp.isEmpty()) {
                        res.add(i);
                        break;
                    }
                } else
                    break;
            }
        }
        return res;
    }

    /**
     * @param s 字符串
     * @param p 模式串
     * @return 滑动窗口
     */
    public List<Integer> findAnagrams1(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] charArray = s.toCharArray();
        if (p.length() > s.length())
            return res;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int begin = 0, end = 0, counter = map.size();
        while (end < charArray.length) {
            char c = charArray[end];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0)
                    counter--;
            }
            end++;
            while (counter == 0) {
                char temp = charArray[begin];
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0)
                        counter++;
                }
                if (end - begin == p.length()) {
                    res.add(begin);
                }
                begin++;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        FindAllAnagrams findAll = new FindAllAnagrams();
        System.out.println(findAll.findAnagrams("abab", "ab"));
        System.out.println(findAll.findAnagrams1("abab", "ab"));
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/3/29 10:07
 * @Description
 */
public class SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0)
            return res;
        if (words[0].length() == 0)
            return res;
        HashMap<String, Integer> totalWords = new HashMap<>();
        for (String w : words) {
            int value = totalWords.getOrDefault(w, 0);
            totalWords.put(w, value + 1);//加入哈希 方便判断，常用手法
        }
        int len = words[0].length();
        int count = words.length;
        for (int i = 0; i < s.length(); i++) {
            int num = 0;
            HashMap<String, Integer> hasWords = new HashMap<>();
            while (num < count && (i + len * count) <= s.length()) {
                String str = s.substring(i + len * num, i + len * (num + 1));
//                System.out.println(str);
                if (totalWords.containsKey(str)) {
                    int value = hasWords.getOrDefault(str, 0);
                    hasWords.put(str, value + 1);
                    if (hasWords.get(str) > totalWords.get(str))
                        break;
                } else {
                    break;
                }
                num++;
            }
            if (num == count)
                res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
    }
}


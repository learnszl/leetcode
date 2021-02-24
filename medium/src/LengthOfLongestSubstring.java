import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author szl
 * @Date 2021/2/24 14:30
 * @Description
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {//暴力破解
        ArrayList<Character> list = new ArrayList<>();
        int N = s.length();
        int ans = 0;
        if (N == 0)
            return 0;
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            for (int j = 0; j < list.size(); j++) {
                if (s.charAt(i) == list.get(j)) {
                    flag = false;
                    i = i - list.size() + 1;
                    break;
                }

            }
            if (flag) {
                list.add(s.charAt(i));
                if (list.size() > ans)
                    ans = list.size();
            } else {
                list.clear();
                list.add(s.charAt(i));
            }

        }
        return ans;

    }

    public static int lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)) + 1, left);
//                System.out.println(left);
            }
            map.put(s.charAt(i), i);

            ans = Math.max(ans, i - left + 1);
            System.out.println(ans);
        }
        return ans;

    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring1(s));
    }

}

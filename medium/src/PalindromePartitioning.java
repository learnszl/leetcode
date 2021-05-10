
import java.util.ArrayList;

import java.util.List;

/**
 * @Author szl
 * @Date 2021/5/10 9:58
 * @Description
 */
public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s.length() == 0)
            return res;
        dfs(res, new ArrayList<>(), s, 0, s.length());
        return res;
    }

    private static void dfs(List<List<String>> res, ArrayList<String> temp, String s, int index, int n) {
        if (index == n) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = index; i < n; i++) {
            if (!isPalindrome(s, index, i))
                continue;
            temp.add(s.substring(index, i + 1));
            dfs(res, temp, s, i+1, n);
            temp.remove(temp.size() - 1);
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("abab"));
    }
}

import java.util.Arrays;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/5/13 10:32
 * @Description 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
//        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if(!dp[i])
                continue;
            for (int j = i + 1; j < n + 1; j++) {
                String word = s.substring(i, j);
                if (dp[i] && wordDict.contains(word))
                    dp[j] = true;
            }
        }
        return dp[n];
    }
}

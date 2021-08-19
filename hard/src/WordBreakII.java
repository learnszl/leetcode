
import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/5/14 9:50
 * @Description 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        dfs(wordDict, s, res, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(List<String> wordDict, String s, List<String> res, ArrayList<String> temp, int index) {
        if (index == s.length()) {
            res.add(String.join(" ", temp));
        }
        for (int i = index; i < s.length(); i++) {
            String sub = s.substring(index, i + 1);
            if (wordDict.contains(sub)) {
                temp.add(sub);
                dfs(wordDict, s, res, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        WordBreakII wordBreakII = new WordBreakII();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        System.out.println(wordBreakII.wordBreak("catsanddog", wordDict));
    }
}


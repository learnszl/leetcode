import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/9/9 10:25
 * @Description 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth个字符，
 * 且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            int len = 0, j = i;
            for (i = j; i < words.length; i++) {
                len = len + words[i].length() + 1;
                if (len > maxWidth + 1) {
                    len = len - words[i].length() - 1;
                    break;
                }
            }
            len -= 1;
            if (i == words.length) {
                StringBuilder temp = new StringBuilder(words[j]);
                System.out.println(temp);
                for (int k = j + 1; k < i; k++) {
                    temp.append(' ');
                    temp.append(words[k]);
                }
                temp.append(generateSpace(maxWidth - len));
                res.add(temp.toString());
                break;
            }
            int num = i - j;
            int sub = maxWidth - len;
            if (num == 1)
                res.add(words[j] + generateSpace(sub));
            else {
                StringBuilder temp = new StringBuilder(words[j]);
                int space = sub / (num - 1);
                int extra = sub - (num - 1) * space;
                for (int k = j + 1; k < i; k++) {
                    if (extra > 0) {
                        temp.append(generateSpace(space + 2));
                        temp.append(words[k]);
                        extra--;
                    } else {
                        temp.append(generateSpace(space + 1));
                        temp.append(words[k]);
                    }
                }
                res.add(temp.toString());
            }
        }
        return res;
    }

    private String generateSpace(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();
        System.out.println(tj.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}

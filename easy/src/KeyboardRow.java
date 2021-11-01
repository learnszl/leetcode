import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/11/1 11:03
 * @Description
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        String[] s = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] hash = new int[26];
        for (int i = 0; i < s.length; i++) {
            for (char c : s[i].toCharArray()) {
                hash[c - 'a'] = i;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        for (String w : words) {
            boolean flag = true;
            int x = -1;
            for (char c : w.toLowerCase().toCharArray()) {
                if (x == -1) {
                    x = hash[c - 'a'];
                } else {
                    if (x != hash[c - 'a']) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag)
                list.add(w);
        }
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        KeyboardRow keyboardRow = new KeyboardRow();
        System.out.println(Arrays.toString(keyboardRow.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }
}

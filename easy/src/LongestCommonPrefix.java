/**
 * @Author szl
 * @Date 2021/3/10 11:45
 * @Description
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        int N = strs.length;
        int minlength = strs[0].length();
        for (int i = 1; i < N; i++) {
            if (strs[i].length() < minlength)
                minlength = strs[i].length();
        }
        String res = "";
        int i = 0;
        while (true) {
            if (i >= minlength)
                break;
            boolean flag = true;
            for (int j = 1; j < N; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                res += strs[0].charAt(i);
                i++;

            } else
                break;


        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(LongestCommonPrefix.longestCommonPrefix(new String[]{"fa", "f", "fff"}));
    }
}

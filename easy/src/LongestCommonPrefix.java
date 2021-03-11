/**
 * @Author szl
 * @Date 2021/3/10 11:45
 * @Description
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {//暴力
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

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0)
            return "";
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            res = findTwoCommonPrefix(res, strs[i]);
            if (res.equals(""))
                return "";
        }
        return res;
    }

    public static String findTwoCommonPrefix(String str1, String str2) {
        StringBuilder res = new StringBuilder();
        int len = Math.min(str1.length(), str2.length());
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) == str2.charAt(i))
                res.append(str1.charAt(i));
            else
                break;
        }
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(LongestCommonPrefix.longestCommonPrefix1(new String[]{"da", "fa", "faff"}));
    }
}

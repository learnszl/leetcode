/**
 * @Author szl
 * @Date 2021/3/19 10:05
 * @Description
 */
public class ImplementStrStr {
    public static int strStr(String haystack, String needle) {//内置api
//        return haystack.indexOf(needle);
        if (needle.length() == 0)
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (needle.equals(haystack.substring(i, i + needle.length())))
                return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }
}

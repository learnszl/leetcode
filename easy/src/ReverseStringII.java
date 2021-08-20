/**
 * @Author szl
 * @Date 2021/8/20 10:39
 * @Description 给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 */
public class ReverseStringII {
    public static String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = charArray.length, i = 0;
        while (i < n) {
            int end = i + k - 1 < n ? i + k - 1 : n - 1, start = i;
            while (start < end) {
                swap(charArray, start, end);
                start++;
                end--;
            }
            i += 2 * k;
        }
        return new String(charArray);
    }

    private static void swap(char[] charArray, int start, int end) {
        char temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcde", 2));
    }
}

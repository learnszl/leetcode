
/**
 * @Author szl
 * @Date 2021/8/19 10:47
 * @Description 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class ReverseVowelsString {
    public static String reverseVowels(String s) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < n && "aeiouAEIOU".indexOf(charArray[left]) < 0)
                left++;
            while (right >= 0 && "aeiouAEIOU".indexOf(charArray[right]) < 0)
                right--;
            if (left < right) {
                char temp = charArray[left];
                charArray[left] = charArray[right];
                charArray[right] = temp;
                left++;
                right--;
            }
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(s);
        System.out.println(reverseVowels("hello"));
    }
}

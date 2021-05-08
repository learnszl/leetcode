
/**
 * @Author szl
 * @Date 2021/5/8 12:09
 * @Description
 */
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        StringBuilder sNew = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i)))
                sNew.append(Character.toLowerCase(s.charAt(i)));
        }
        System.out.println(sNew);
        int left = 0, right = sNew.length() - 1;
        while (left < right) {
            if (sNew.charAt(left) == sNew.charAt(right)) {
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println((isPalindrome("A man, a plan, a canal: Panama")));
    }
}

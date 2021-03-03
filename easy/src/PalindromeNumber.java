/**
 * @Author szl
 * @Date 2021/3/3 16:52
 * @Description
 */
public class PalindromeNumber {
    public static boolean palindromeNumber(int x) {
        if (x < 0)
            return false;
        if (x < 10)
            return true;
        String s = String.valueOf(x);
        boolean isPalindrome = true;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                isPalindrome = false;
                break;
            }
            i++;
            j--;
        }
        return isPalindrome;

    }

    public static void main(String[] args) {
        System.out.println(PalindromeNumber.palindromeNumber(101));
    }
}

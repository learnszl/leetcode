import java.beans.beancontext.BeanContext;

/**
 * @Author szl
 * @Date 2021/2/25 20:57
 * @Description
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s.length() == 0)
            return "";
        if(s.length() == 1)
            return s;
        int start = 0,end = 0,len = 0;
        int m = 0, n = 0;
        int N = s.length();
        for (int i = 1; i < N - 1; i++) {
            start = i - 1;
            end = i + 1;
            while(start >= 0 && end < N){
                if(s.charAt(start) == s.charAt(end)){
                    start--;
                    end++;

                }
                else
                    break;
            }

            if(start - end > len){
                len = start - end;
                m = start;
                n = end;
            }

        }
        return s.substring(m,n);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ab"));
    }
}

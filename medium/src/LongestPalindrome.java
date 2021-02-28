
/**
 * @Author szl
 * @Date 2021/2/25 20:57
 * @Description
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {//中心扩展算法
        int N = s.length();
        if (N < 2)
            return s;
        int start = 0;
        int end = 0;
        int len ;
        for (int i = 0; i < N; i++) {
            int lenodd = expandCenter(s, i, i);
            int leneven = expandCenter(s, i, i + 1);
            len = Math.max(lenodd, leneven);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);


    }

    public int expandCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }


    public String longestPalindrome1(String s) {//动态规划
        int N = s.length();
        if(N < 2)
            return s;
        boolean[][] dp = new boolean[N][N];
        String ans = "";
        return ans;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abbb"));
    }
}

import java.util.ArrayList;

/**
 * @Author szl
 * @Date 2021/2/24 14:30
 * @Description
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {//暴力破解
        ArrayList<Character> list = new ArrayList<>();
        int N = s.length();
        int ans = 0;
        if (N == 0)
            return 0;
        for (int i = 0; i < N; i++) {
            boolean flag  = true;
            for (int j = 0; j < list.size(); j++) {
                if (s.charAt(i) == list.get(j)){
                    flag = false;
                    i = i - list.size() + 1;
                    break;
                }

            }
            if(flag){
                list.add(s.charAt(i));
                if(list.size() > ans)
                    ans = list.size();
            }
            else{
                list.clear();
                list.add(s.charAt(i));
            }

        }
        return  ans;

    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

}

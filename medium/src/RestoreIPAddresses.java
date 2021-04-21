import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/4/21 10:22
 * @Description
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        ArrayList<String> res = new ArrayList<>();
        if (len < 4 || len > 12)
            return res;
        dfs(s, res, len, 0, 0, new ArrayList<>());
        return res;
    }

    public void dfs(String s, List<String> res, int len, int begin, int spilt, List<String> temp) {
        if (begin == len) {
            if (spilt == 4) {
                res.add(String.join(".", temp));
            }
            return;
        }
        if (len - begin < (4 - spilt) || len - begin > 3 * (4 - spilt))
            return;
        for (int i = 0; i < 3; i++) {
            if (begin + i >= len)
                break;
            int ipSegment = isIpSegment(s, begin, begin + i);
            if (ipSegment != -1) {
                temp.add(String.valueOf(ipSegment));
                dfs(s, res, len, begin + i + 1, spilt + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public int isIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0')
            return -1;
        int res = 0;
        for (int i = left; i <= right; i++) {
            res = res * 10 + s.charAt(i) - '0';
        }
        if (res > 255)
            return -1;
        return res;
    }

    public static void main(String[] args) {
        RestoreIPAddresses restoreIPAddresses = new RestoreIPAddresses();
        System.out.println(restoreIPAddresses.restoreIpAddresses("25525511135"));
//        List<String> res = new ArrayList<>();
//        res.add("123");
//        res.add("456");
//        System.out.println(String.join("&&&", res));
    }
}

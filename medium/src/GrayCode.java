
import java.util.ArrayList;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/4/16 15:30
 * @Description
 */
public class GrayCode {
    public static List<Integer> grayCode(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);
        res.add(1);
        for (int i = 1; i < n; i++) {
            int len = res.size();
            int add = 1 << i;
            for (int j = 0; j < len; j++) {
                res.add(res.get(len - j - 1) + add);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(3));
    }
}

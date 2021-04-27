
import java.util.ArrayList;
import java.util.List;


/**
 * @Author szl
 * @Date 2021/4/27 10:03
 * @Description
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 2; i <= numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            List<Integer> last = res.get(res.size() - 1);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1)
                    temp.add(1);
                else {
                    temp.add(last.get(j) + last.get(j - 1));
                }
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}

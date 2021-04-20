import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author szl
 * @Date 2021/4/17 19:02
 * @Description
 */
public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>>res = new ArrayList<>();
        res.add(new ArrayList<>());
        

        return res;
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));
    }
}

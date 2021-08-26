import java.util.Arrays;
import java.util.HashMap;
import java.util.IdentityHashMap;

/**
 * @Author szl
 * @Date 2021/8/26 10:11
 * @Description 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 */
public class BoatsSavePeople {
    /**
     * @param people 重量
     * @param limit  限制
     * @return 超时
     */
    public static int numRescueBoats(int[] people, int limit) {
        int w = limit - 1, res = 0;
        HashMap<Integer, Integer> freWeight = new HashMap<>();
        for (int p : people) {
            if (p == limit)
                res++;
            else
                freWeight.put(p, freWeight.getOrDefault(p, 0) + 1);
        }
//        System.out.println(res);
        while (!freWeight.isEmpty()) {
            while (freWeight.containsKey(w)) {
                if (freWeight.get(w) == 1)
                    freWeight.remove(w, 1);
                else
                    freWeight.put(w, freWeight.get(w) - 1);
                for (int i = 1; i <= limit - w; i++) {
                    if (freWeight.containsKey(i)) {
                        System.out.println(res);
                        if (freWeight.get(i) == 1)
                            freWeight.remove(i, 1);
                        else
                            freWeight.put(i, freWeight.get(i) - 1);
//                        System.out.println(freWeight);
                        break;
                    }
                }
                res++;
            }
            w--;
        }
        return res;
    }

    public static int numRescueBoats1(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int low = 0, high = people.length - 1;
        while (low <= high) {
            if (people[low] + people[high] > limit)
                high--;
            else {
                high--;
                low++;
            }
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(numRescueBoats1(new int[]{3, 5, 3, 4}, 5));
    }
}

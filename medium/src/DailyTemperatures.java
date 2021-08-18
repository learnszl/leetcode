import java.util.*;

/**
 * @Author szl
 * @Date 2021/8/17 18:19
 * @Description 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                res[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}

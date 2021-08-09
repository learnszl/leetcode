import java.util.*;

/**
 * @Author szl
 * @Date 2021/8/9 10:57
 * @Description 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {//超时
        if (n <= 6)
            return n;
        int res = 7;
        while (n != 6) {
            if (isUgly(res))
                n--;
            res++;
        }
        return --res;
    }

    private boolean isUgly(int n) {
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0)
                n /= factor;
        }
        return n == 1;
    }

    public int nthUglyNumber1(int n) {//超时
        if (n <= 6)
            return n;
        ArrayList<Double> value = new ArrayList<>();
        value.add(2.0);
        value.add(3.0);
        value.add(4.0);
        value.add(5.0);
        value.add(6.0);
        int res = 7;
        while (n > 6) {
            System.out.println(n);
            for (int i = 0; i < value.size(); i++) {
                if (value.contains((double) res / value.get(i))) {
                    value.add((double) res);
                    n--;
                    break;
                }
            }
            res = res + 1;
        }
        System.out.println(value);
        return res - 1;
    }

    public int nthUglyNumber2(int n) {//最小堆
        int[] factors = {2, 3, 5};
        HashSet<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.offer(1L);
        int res = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            res = (int) curr;
            for (int factor : factors) {
                long addNum = curr * factor;
                if (set.add(addNum)) {
                    heap.offer(addNum);
                }
            }
        }
        return res;
    }

    public int nthUglyNumber3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p1 = 1, p2 = 1, p3 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p1] * 2, num3 = dp[p2] * 3, num5 = dp[p3] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2)
                p1++;
            if (dp[i] == num3)
                p2++;
            if (dp[i] == num5)
                p3++;
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }


    public static void main(String[] args) {
        UglyNumberII ugn = new UglyNumberII();
        System.out.println(ugn.nthUglyNumber3(10));
    }
}

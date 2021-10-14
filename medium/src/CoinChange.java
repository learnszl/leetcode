import java.util.Arrays;

/**
 * @Author szl
 * @Date 2021/9/8 16:09
 * @Description 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {
    int res = Integer.MAX_VALUE;

    /**
     * @param coins  硬币
     * @param amount 总金额
     * @return dfs无记忆 超时
     */

    public int coinChange(int[] coins, int amount) {
        dfs(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void dfs(int[] coins, int amount, int temp) {
        if (amount < 0)
            return;
        if (amount == 0) {
//            System.out.println(temp);
            if (temp < res)
                res = temp;
            return;
        }
        for (int coin : coins) {
            dfs(coins, amount - coin, temp + 1);
        }
    }

    public int coinChange1(int[] coins, int amount) {
        return dfs(coins, amount, new int[amount]);
    }

    private int dfs(int[] coins, int rem, int[] count) {
        if (rem < 0)
            return -1;
        if (rem == 0)
            return 0;
        if (count[rem - 1] != 0)
            return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        count[rem - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[rem - 1];
    }

    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int x1 = coinChange.coinChange(new int[]{1, 2, 5}, 11);
        int x3 = coinChange.coinChange2(new int[]{1, 2, 5}, 11);
        int x2 = coinChange.coinChange1(new int[]{1, 2}, 4);
        System.out.println(x3);
    }
}

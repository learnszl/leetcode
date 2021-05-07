/**
 * @Author szl
 * @Date 2021/5/7 9:52
 * @Description
 */
public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length, res = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            res = Math.max(res, price - minPrice);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{}));
    }
}

/**
 * @Author szl
 * @Date 2021/5/7 11:19
 * @Description
 */
public class BestTimetoBuyandSellStockII {
    public static int maxProfit(int[] prices) {
        int minPrice = prices[0], res = 0;
        for (int price : prices) {
            if (price > minPrice) {
                res = res + price - minPrice;
            }
            minPrice = price;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

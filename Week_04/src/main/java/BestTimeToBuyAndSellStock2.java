public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int delta = prices[i] - prices[i-1];
            if(delta > 0){
                maxProfit += delta;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = new int [] {7,1,5,3,6,4};
        BestTimeToBuyAndSellStock2 bestTimeToBuyAndSellStock2 = new BestTimeToBuyAndSellStock2();
        System.err.println(bestTimeToBuyAndSellStock2.maxProfit(prices));
    }

}

package cn.edu.lich.algo;

public class BestTimetoBuyandSellStockIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BestTimetoBuyandSellStockIII btb = new BestTimetoBuyandSellStockIII();
		System.out.println(btb.maxProfit(new int[]{1, 2}));
	}
	
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
	   if(prices == null || prices.length == 0) return 0;
       int[] historyProfit = new int[prices.length];
       int[] futureProfit = new int[prices.length];
       int maxProfit = 0;
       int curMinPrice = prices[0];
       for(int i = 0; i < prices.length; i++){
    	   if(curMinPrice > prices[i]){
    		   curMinPrice = prices[i];
    	   }
    	   if(i > 0){
    		   historyProfit[i] = Math.max(historyProfit[i - 1], prices[i] - curMinPrice);
    	   }
       }
       int curMaxPrice = prices[prices.length - 1];
       for(int i = prices.length - 1; i >= 0; i--){
    	   if(curMaxPrice < prices[i]){
    		   curMaxPrice = prices[i];
    	   }
    	   if(i < prices.length - 1){
    		   futureProfit[i] = Math.max(futureProfit[i + 1], curMaxPrice - prices[i]);
    	   }
    	   maxProfit = Math.max(maxProfit, futureProfit[i] + historyProfit[i]);
       }
       return maxProfit;
    }

}

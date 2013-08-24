package cn.edu.lich.algo;

public class BestTimetoBuyandSellStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() functionome 
		int profit = 0;
		for(int i = 1; i < prices.length; i++){
			if(prices[i] > prices[i-1]){
				profit += (prices[i] - prices[i-1]);
			}else {
				
			}
		}
		return profit;
    }

}

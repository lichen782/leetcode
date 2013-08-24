package cn.edu.lich.algo;

public class BestTimetoBuyandSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BestTimetoBuyandSellStock bbs = new BestTimetoBuyandSellStock();
		System.out.println(bbs.maxProfit2(new int[] {1, 2}));
	}
	
	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int maxProfit = 0;
        for(int j = prices.length - 1; j >= 0; j--){
        	if(maxProfit > prices[j]) continue;
        	for(int i = 0; i < j; i++){
        		int p = prices[j] - prices[i];
        		if(p > maxProfit) maxProfit = p;
        	}
        }
        return maxProfit;
    }
	
	
	public int maxProfit2(int[] prices){
		int maxProfit = 0;
//		int buy = 0;
//		int sell = 0;
		int min = 0;
		for(int i = 0; i < prices.length; i++){
			if(prices[min] > prices[i]) {
				min = i;
			}
			int profit = prices[i] - prices[min];
			if(profit > maxProfit) {
				maxProfit = profit;
//				buy = min;
//				sell = i;
			}
		}
		return maxProfit;
	}

}

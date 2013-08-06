package cn.edu.lich.algo;

public class BestTimetoBuyandSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

}

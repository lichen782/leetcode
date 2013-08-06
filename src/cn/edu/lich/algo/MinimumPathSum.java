package cn.edu.lich.algo;

public class MinimumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
	
	private int[][] cost;
	
	public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int m = grid.length;
		int n = m != 0 ? grid[0].length : 0;
        cost = new int[m][n];
        int sum = 0;
        for(int i = n - 1; i >= 0; i--){
        	cost[m-1][i] = (sum+= grid[m-1][i]);
        }
        sum = 0;
        for(int i = m - 1; i >= 0; i--){
        	cost[i][n-1] = (sum+=grid[i][n-1]);
        }
        for(int i = m - 2; i >= 0; i--){
        	for(int j = n - 2; j >= 0; j--){
        		cost[i][j] = grid[i][j] + Math.min(cost[i + 1][j], cost[i][j+1]);
        	}
        }
        
        return cost[0][0];
	}

}

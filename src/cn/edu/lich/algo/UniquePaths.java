package cn.edu.lich.algo;

public class UniquePaths {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(3, 4));
	}
	
	private int[][] cost;
	
	public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        cost = new int[m][n];
        for(int i = 0; i < m; i++){
        	cost[i][n-1] = 1;
        }
        for(int i = 0; i < n; i++){
        	cost[m-1][i] = 1;
        }
        
        for(int i = m - 2; i >= 0; i--){
        	for(int j = n - 2; j >= 0; j--){
        		cost[i][j] = cost[i+1][j] + cost[i][j+1];
        	}
        }
        return cost[0][0];
	 }
	 
	 

}

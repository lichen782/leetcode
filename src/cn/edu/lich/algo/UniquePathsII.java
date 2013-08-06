package cn.edu.lich.algo;

public class UniquePathsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] obstacleGrid = {
								{0},
								{0},
						};
		UniquePathsII up = new UniquePathsII();
		System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
	}
	private int[][] cost;
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		cost = new int[m][n];
		int lastObstcle_row = -1;
		int lastObstcle_col = -1;
		
		for(int i = m - 1; i >= 0; i--){
			if(obstacleGrid[i][n-1] == 1){
				lastObstcle_row = i;
			}
			if(i > lastObstcle_row) cost[i][n-1] = 1;
			else cost[i][n-1] = 0;
		}
		
		for(int i = n - 1; i >= 0; i--){
			if(obstacleGrid[m-1][i] == 1){
				lastObstcle_col = i;
			}
			if(i > lastObstcle_col) cost[m - 1][i] = 1;
			else cost[m - 1][i] = 0;
		}
        
        for(int i = m - 2; i >= 0; i--){
        	for(int j = n - 2; j >= 0; j--){
        		if(obstacleGrid[i][j] == 1) cost[i][j] = 0;
        		else {
        			cost[i][j] = cost[i+1][j] + cost[i][j+1];
        		}
        	}
        }
        return cost[0][0];
	}

}

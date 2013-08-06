package cn.edu.lich.algo;

public class SpiralMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpiralMatrixII sm = new SpiralMatrixII();
		printMatrix(sm.generateMatrix(3));
	}
	
	public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int cnt = 1;
		int[][] matrix = new int[n][];
		for(int i = 0; i < n; i++){
			matrix[i] = new int[n];
		}
		int row = 0;
		int col = 0;
        for(int level = 0; level < n/2; level++){
        	row = level;
        	col = level;
        	int border = n - 1 - level;
        	while(col < border){
        		matrix[row][col++] = cnt++;
        	}
        	while(row < border){
        		matrix[row++][col] = cnt++;
        	}
        	while(col > level){
        		matrix[row][col--] = cnt++;
        	}
        	while(row > level){
        		matrix[row--][col] = cnt++;
        	}
        }
        if(n%2 == 1) matrix[n/2][n/2] = cnt;
        return matrix;
    }
	
	public static void printMatrix(int[][] matrix){
		for(int i = 0; i < matrix.length; i++){
			for(int n : matrix[i]){
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}

}

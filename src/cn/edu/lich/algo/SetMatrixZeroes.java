package cn.edu.lich.algo;

public class SetMatrixZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] matrix = {
//				{0,0,0,5},
//				{4,3,1,4},
//				{0,1,1,4},
//				{1,2,1,3},
//				{0,0,1,1}
//		};
		int[][] matrix = {
				{8,3,1,4,			6,4,0,3,4},
				{9,1,3,0,			1,5,7,4,1},
				{2,2,5,2147483647,	5,4,4,3,8},
				{4,9,7,0,			3,6,9,5,9},
				{4,1,8,8,			4,1,5,7,6}
		};
		SetMatrixZeroes smz = new SetMatrixZeroes();
		smz.setZeroes(matrix);
		printMatrix(matrix);
	}
	
	public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int m = matrix.length;
		int n = m == 0 ? 0 : matrix[0].length;
		boolean[] isSet = new boolean[m * n];
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		if(matrix[i][j] == 0){
        			int cnt = i * n + j;
        			isSet[cnt] = true;
        		}
        	}
        }
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		int cnt = i * n + j;
        		if(isSet[cnt]){
        			setRowZero(matrix, i, n);
        			setColZero(matrix, j, m);
        		}
        	}
        }
    }
	
	
	private void setRowZero(int[][] matrix, int row, int n){
		for(int i = 0; i < n; i++){
			matrix[row][i] = 0;
		}
	}
	private void setColZero(int[][] matrix, int col, int m){
		for(int i = 0; i < m; i++){
			matrix[i][col] = 0;
		}
	}
	
	public static void printMatrix(int[][] matrix){
		int m = matrix.length;
		int n = m == 0 ? 0 : matrix[0].length;
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n; j++){
        		System.out.print(matrix[i][j] + " ");
        	}
        	System.out.println();
        }
	}

}

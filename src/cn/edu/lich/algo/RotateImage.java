package cn.edu.lich.algo;

public class RotateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public static void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[][] tmp = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++){
        	tmp[i] = new int[matrix.length];
        }
        for(int row = 0; row < matrix.length; row++){
        	for(int col = 0; col < matrix.length; col++){
        		tmp[col][matrix.length - row - 1] = matrix[row][col];
        	}
        }
        for(int row = 0; row < matrix.length; row++){
        	for(int col = 0; col < matrix.length; col++){
        		matrix[row][col] = tmp[row][col];
        	}
        }
    }

}

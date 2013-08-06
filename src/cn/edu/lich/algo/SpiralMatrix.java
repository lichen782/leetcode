package cn.edu.lich.algo;

import java.util.ArrayList;

public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = {	{1,2,3},
//				{2},
//				{3}
//							{4,5,6},
//							{7, 8, 9},
							};
		System.out.println(sm.spiralOrder(matrix));
	}
	
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();
		int row = 0;
		int col = 0;
		int rows = matrix.length;
		if(rows == 0) return result;
		int cols = matrix[0].length;
		int shorter = Math.min(rows, cols);
		for(int level = 0, left_col = cols - 1, bottom_row = rows - 1; 
				level < shorter / 2 + shorter % 2; level++, left_col--, bottom_row--){
			row = level;
			col = level;
			if(bottom_row == level){
				while(col <= left_col)
					result.add(matrix[row][col++]);
				continue;
			}
			
			if(left_col == level){
				while(row <= bottom_row)
					result.add(matrix[row++][col]);
				continue;
			}
			//upper row
			while(col < left_col){
				result.add(matrix[row][col++]);
			}
			
			while(row < bottom_row){
				result.add(matrix[row++][col]);
			}
			
			
			while(col > level){
				result.add(matrix[row][col--]);
			}
			
			while(row > level){
				result.add(matrix[row--][col]);
			}
			
		}
		return result;
    }

}

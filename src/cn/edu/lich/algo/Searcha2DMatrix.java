package cn.edu.lich.algo;

public class Searcha2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[][] matrix = {
//				{1,   3,  5,  7},	
//				{10, 11, 16, 20},
//				{23, 30, 34, 50}
//		};
		int[][] matrix = {
				{1,3}
		};
		Searcha2DMatrix sm = new Searcha2DMatrix();
		System.out.println(sm.searchMatrix(matrix, 3));
	}
	
	public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int r = binarySearchByRow(matrix, target);
        if(r < matrix.length && matrix[r][0] == target) return true;
        if(r == 0) return false;
        r--;
        if(binarySearchByCols(matrix, target, r) > 0){
        	return true;
        }else return false;
    }
	
	private int binarySearchByRow(int[][] matrix, int target){
		int lo = 0;
		int hi = matrix.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(target > matrix[mid][0]){
				lo = mid + 1;
			}else if(target < matrix[mid][0]){
				hi = mid - 1;
			}else return mid;
		}
		return lo;
	}
	
	private int binarySearchByCols(int[][] matrix, int target, int row){
		int lo = 0;
		int hi = matrix[0].length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(target > matrix[row][mid]){
				lo = mid + 1;
			}else if (target < matrix[row][mid]){
				hi = mid - 1;
			}else return mid;
		}
		return -1;
	}

}

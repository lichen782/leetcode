package cn.edu.lich.algo;

public class SearchinRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
	
	public static int search1(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
		return search2(A,target);
    } 
	
	private static int search2(int[] A, int target){
		int lo = 0;
		int hi = A.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(target == A[mid]) return mid;
			if(A[mid] > lo){
				if(target >= A[lo] && target < A[mid]){
					hi = mid - 1;
				}else {
					lo = mid + 1;
				}
			}else {
				if(target <= A[hi] && target > A[mid]){
					lo = mid + 1;
				}else {
					hi = mid -1;
				}
			}
		}
		return -1;
	}

}

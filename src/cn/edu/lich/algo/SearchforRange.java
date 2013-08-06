package cn.edu.lich.algo;

public class SearchforRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {2,2};
		int[] B = searchRange(A, 2);
		System.out.println(B[0] + " " + B[1]);
	}
	
	public static int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int exist = binarySearch(A, target);
        if(exist < A.length && A[exist] == target){
        	int lower = binarySearch(A, target - 0.5);
        	int higher = binarySearch(A, target + 0.5);
        	return new int[]{lower, higher - 1};
        	
        }else return new int[]{-1,-1};
    }
	
	private static int binarySearch(int[] A, double target){
		int lo = 0;
		int hi = A.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(target > A[mid]){
				lo = mid + 1;
			}else if (target < A[mid]){
				hi = mid - 1;
			}else return mid;
		}
		return lo;
	}

}

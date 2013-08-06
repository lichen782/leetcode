package cn.edu.lich.algo;

public class SearchinRotatedSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] A = {1,3,1,1,1};
		SearchinRotatedSortedArrayII srsa = new SearchinRotatedSortedArrayII();
		System.out.println(srsa.search(A, 3));
	}
	
    public boolean search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int lo = 0;
        int hi = A.length - 1;
        while(lo <= hi){
        	int mid = lo + (hi - lo)/2;
        	if(target == A[mid]) return true;
        	if(A[mid] > A[lo]){
        		if(target < A[mid] && target >= A[lo]){
        			hi = mid - 1;
        		}else {
        			lo = mid + 1;
        		}
        	}else if(A[mid] < A[lo]){
        		if(target > A[mid] && target <= A[hi]){
        			lo = mid + 1;
        		}else {
        			hi = mid - 1;
        		}
        	}else {
        		for(int i = lo; i <= hi; i++){
        			if(A[i] == target) return true;
        		}
        		return false;
        	}
        }
        return false;
    }

}

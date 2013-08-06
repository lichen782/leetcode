package cn.edu.lich.algo;

public class RemoveDuplicatesfromSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,1,2,2,2,3,3,3,3,3};
		RemoveDuplicatesfromSortedArrayII rsa = new RemoveDuplicatesfromSortedArrayII();
		int length = rsa.removeDuplicates(A);
		System.out.println(length);
		for(int i = 0; i < length; i++){
			System.out.print(A[i] + " ");
		}
	}	
	
	public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int length = A.length;
		int cnt = 1;
	    for(int i = 1; i < length; i++){
	    	if(A[i] == A[i-1]){
	    		cnt++;
	    	}else {
	    		if(cnt > 2){
	    			int shift = cnt - 2;
	    			for(int j = i; j < length; j++){
	    				A[j - shift] = A[j];
	    			}
	    			length -= shift;
	    			i -= (shift + 1);
	    		}
	    		cnt = 1;
	    	}
	    }
	    if(cnt > 2){
	    	int shift = cnt - 2;
	    	length -= shift;
	    }
	    return length;
	}
}

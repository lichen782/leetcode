package cn.edu.lich.algo;

public class FirstMissingPositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(firstMissingPositive2(new int[]{3,4,-1,1}));
	}
	
	 public static int firstMissingPositive(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	       int bits = 0;
	       for(int i = 0; i < A.length; i++){
	    	   if(A[i] > 0){
	    		   bits |= (1 << (A[i] - 1));
	    	   }
	       }
	       int idx = 0;
	       while(bits%2 != 0){
	    	   bits = (bits >> 1);
	    	   idx++;
	       }
	       return idx + 1;
	 }
	 
	 public static int firstMissingPositive2(int[] A){
		for(int i = 0; i < A.length; i++){
			if(A[i] > 0 && A[i] <= A.length){
				if(A[i] != i + 1 && A[A[i] - 1] != A[i]){
					int tmp = A[A[i] - 1];
					A[A[i] - 1] = A[i];
					A[i] = tmp;
					i--;
				}
			}
		}
		
		for(int i = 0; i < A.length; i++){
			if(A[i] != i+1){
				return i+1;
			}
		}
		return A.length + 1;
	 }

}

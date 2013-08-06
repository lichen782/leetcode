package cn.edu.lich.algo;

public class JumpGameII {

	private static final int INFINITE = 10000000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(jump2(new int[]{2,3,1,1,4}));
	}
	
	 public static int jump(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 if(A.length < 2) return 0;
		 int[] dist = new int[A.length];
		 int[] to = new int[A.length];
		 for(int i = 0; i < A.length; i++){
			 dist[i] = INFINITE;
		 }
		 dist[A.length - 1] = 0;
	     for(int i = A.length - 2; i >= 0; i--){
	    	 int minDist = INFINITE;
	    	 for(int j = 1; j <= A[i] && i + j < A.length; j++){
	    		 int nextIdx = i + j;
	    		 if(nextIdx < A.length){
	    			 int candidate = dist[nextIdx] + 1;
	    			 if(candidate < minDist){
	    				 minDist = candidate;
	    				 to[i] = nextIdx;
	    			 }
	    		 }
	    	 }
	    	 dist[i] = minDist;
	     }
	     return dist[0];
	 }
	 
	 public static int jump2(int[] A){
		 if(A.length < 2) return 0;
		 int ret = 0;
		 int curr = 0;
		 int last = 0;
		 for(int i = 0; i < A.length; i++){
			 if(i > last){
				 last = curr;
				 ret++;
			 }
			 curr = Math.max(curr, i + A[i]);
		 }
		 return ret;
	 }

}

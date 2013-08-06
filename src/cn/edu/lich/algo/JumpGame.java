package cn.edu.lich.algo;

public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] A = {3,2,1,0,4};
		System.out.println(jg.canJump(A));
	}
	
	 public boolean canJump(int[] A) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	    int last = 0;
	    int cur = 0;
	    for(int i = 0; i < A.length; i++){
	    	if(i > last){
	    		last = cur;
	    		if(last < i) return false;
	    	}
	    	cur = Math.max(cur, i + A[i]);
	    }
	    return true;
	 }

}

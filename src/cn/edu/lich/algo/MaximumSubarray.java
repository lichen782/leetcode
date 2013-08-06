package cn.edu.lich.algo;

public class MaximumSubarray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		int[] A = {-2,-1};
		System.out.println("max Sum is : " + ms.maxSubArray(A));
		System.out.println("from " + ms.GetMaxSumSuarrayStartIndex() + " to " + ms.GetMaxSumSuarrayEndIndex());
	}
	
	private int im;
	private int jm;
	
	public int GetMaxSumSuarrayStartIndex() {
		return im;
	}
	
	public int GetMaxSumSuarrayEndIndex() {
		return jm;
	}
	
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        im = 0;
        jm = 0;
        int ik = 0;
        int jk = 0;
        int currentMaxSum = A[im];
        int currentAccumulatedSum = 0;
        while(jk < A.length){
        	currentAccumulatedSum += A[jk];
        	if(currentAccumulatedSum > currentMaxSum){
        		im = ik;
    			jm = jk;
    			currentMaxSum = currentAccumulatedSum;
        	}
        	if(currentAccumulatedSum < 0){//ik ~ jk can't possibly contribute to subsequent sum, as they are already < 0
        		//reset ik;
        		currentAccumulatedSum = 0;
        		ik = ++jk;
        	}else jk++;
        }
        return currentMaxSum;
    }

}

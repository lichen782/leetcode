package cn.edu.lich.algo;

/**
 * TODO Given an array of integers. Find two disjoint contiguous sub-arrays 
 * such that the absolute difference between the sum of two sub-array is maximum. 
 *
 * @author lich
 *
 */
public class SearchMostDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	}
	
//	private int split;
//	private int left;
//	private int right;
//	
//	public int maxDiff(int[] A){
//		if(A.length == 1) return A[0];
//		if(A.length == 2) return Math.max(A[1], A[0]) - Math.min(A[1], A[0]);
//		split = 0;
//		left = 0;
//		right = 1;
//		
//	}
	
//	private static int[] consecutiveSubArrayOf(int[] A, boolean maxSum) {
//		int im = 0;
//		int jm = 0;
//		int ik = 0;
//		int jk = 0;
//		int accumulatedSum = 0;
//		int maxOrMinSoFar = A[im];
//		while(jk < A.length){
//			accumulatedSum += A[jk];
//			if(maxSum ? accumulatedSum > maxOrMinSoFar : accumulatedSum < maxOrMinSoFar) {
//				maxOrMinSoFar = accumulatedSum;
//				im = ik;
//				jm = jk;
//			}
//			if(maxSum ? accumulatedSum < 0 : accumulatedSum > 0){
//				accumulatedSum = 0;
//				ik = ++jk;
//			}else ++jk;
//		}
//		return new int[]{im, jm};
//	}
	
//	private static int sumOf(int[] A, int st, int ed){
//		int sum = 0;
//		for(int i = st; i <= ed; i++){
//			sum += A[i];
//		}
//		return sum;
//	}

}

package cn.edu.lich.algo;

public class RemoveDuplicatesfromSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,1,2,3};
		int length = removeDuplicates(A);
		for(int i = 0; i < length;i++){
			System.out.print(A[i] + " ");
		}
	}
	
	public static int removeDuplicates(int[] A){
		int dup = 0;
		int cur = 0;
		int length = A.length;
		for(int i = 1; i < length; i++){
			if(A[i] == A[i-1]){
				dup++;
				cur++;
			}else {
				if(cur != 0){
					for(int j = i; j < length; j++){
						A[j - cur] = A[j];
					}
					i = i - cur - 1; 
					length -= cur;
					cur=0;
				}
			}
		}
		return A.length - dup;
	}

}

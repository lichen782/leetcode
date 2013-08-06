package cn.edu.lich.algo;

public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] A = 
	}
	
	public static int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int length = A.length;
		for(int i = 0; i < length;i++){
			if(A[i] == elem){
				for(int j = i+1;j<length;j++){
					A[j - 1] = A[j];
				}
				length--;
				i--;
			}
		}
		return length;
    }

}

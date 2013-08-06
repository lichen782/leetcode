package cn.edu.lich.algo;

public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1};
		int[] B = {};
		MergeSortedArray msa = new MergeSortedArray();
		msa.merge(A, 1, B, 0);
		for(int a = 0; a < 1; a++){
			System.out.println(A[a]);
		}
	}
	
	public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int[] aux = new int[m + n];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < m && j < n){
			if(A[i] < B[j]){
				aux[k++] = A[i++];
			}else {
				aux[k++] = B[j++];
			}
		}
		if(i >= m){
			while(j < n) aux[k++] = B[j++];
		}else while(i < m) aux[k++] = A[i++];
		for(int a = 0; a < m + n; a++){
			A[a] = aux[a];
		}
    }

}

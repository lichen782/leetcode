package cn.edu.lich.algo;

public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1,2,0,1,1,2,2,0,0,0,1,0,1,2};
		SortColors sc = new SortColors();
		sc.sortColors(A);
		print(A);
	}
	
	public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
	    int lt = 0;
	    int gt = A.length - 1;
	    int i = 0;
	    while(i <= gt){
	    	//0 ~ lt - 1: 0
	    	//lt ~ i - 1: 1
	    	//i ~ gt: unchk
	    	//gt + 1 ~ A.length - 1: 2
	    	if(A[i] == 0) {
	    		swap(A, i, lt);
	    		i++;
	    		lt++;
	    	}else if(A[i] == 1){
	    		i++;
	    	}else if(A[i] == 2){
	    		swap(A, i, gt);
	    		gt--;
	    	}
	    }
	 }
	
	private void swap(int[]A, int i, int j){
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
	}
	
	public static void print(int[] A){
		for(int i : A){
			System.out.print(i);
		}
	}

}

package cn.edu.lich.algo;

public class UniqueBinarySearchTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniqueBinarySearchTrees ubst = new UniqueBinarySearchTrees();
		
		System.out.println(ubst.numTrees(3));
	}
	
	public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(n <= 0) return 0;
		if(n == 1) return 1;
		int sum = 0;
		for(int i = 1; i <= n; i++){
			int left = numTrees(i - 1);
			int right = numTrees(n - i);
			if(left == 0 || right == 0) sum += Math.max(left, right);
			else sum += left*right;
		}
		return sum;
    }

}

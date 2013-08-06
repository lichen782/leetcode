package cn.edu.lich.algo;

public class ClimbingStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbStairs(10));
	}
	
	public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        int pre1 = 2;
        int pre2 = 1;
        int sum = 0;
        for(int i = 3; i <= n; i++){
        	sum = pre1 + pre2;
        	pre2 = pre1;
        	pre1 = sum;
        }
        return sum;
    }
}

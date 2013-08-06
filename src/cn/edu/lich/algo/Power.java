package cn.edu.lich.algo;

public class Power {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(pow2(0.00001, 2147483647));
	}
	
	public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		double rst = 1;
        for(int i = 0; i < Math.abs(n); i++){
        	rst *= x;
        }
		
        return n>= 0 ? rst : (double)1/(double)rst;
    }
	
	public static double pow2(double x, int n){
		double rsl = internalPower(x, Math.abs(n));
		return n>=0 ? rsl : (double)1/(double)rsl;
	}
	
	// n has to be NON-NEGATIVE
	private static double internalPower(double x, int n){
		if(n == 0) return 1;
		if(n == 1) return x;
		int an = n/2;
		int rmd = n%2;
		double rslt = internalPower(x,an);
		rslt *= rslt;
		if(rmd != 0) rslt *= x;
		return rslt;
	}

}

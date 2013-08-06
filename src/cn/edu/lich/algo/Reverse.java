package cn.edu.lich.algo;

/**
 * Reverse digits of an integer.
 * @author lich
 *
 */
public class Reverse {

	public static void main(String[] args){
		int i = -123;
		System.out.println(reverse(i));
	}
	
	private static int reverse(int x) {
		int xc = x;
		int rev = 0;
		if(xc < 0) xc = -xc;
		while(xc>0){
			rev += xc % 10;
			xc = xc/10;
			rev = rev * 10;
		}
		return x < 0 ? -rev/10 : rev/10;
	}
}

package cn.edu.lich.algo;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * @author lich
 *
 */

public class PalindromeNumber {
	
	public static void main(String[] args) {
		int i = 2147447412;
		System.out.println(i + (isPalindrome(i)? " is " : " is not ") + "palindrome");
	}

	 public static boolean isPalindrome(int x) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		 if(x < 0) return false;
	     return x == reverse(x);
	 }
	 
	 private static int reverse(int x) {
			int xc = x;
			int rev = 0;
			if(xc < 0) xc = -xc;
			while(xc>0){
				rev += xc % 10;
				xc = xc/10;
				if(xc == 0)break;
				rev = rev * 10;
			}
			return x < 0 ? -rev : rev;
		}
}

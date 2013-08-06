package cn.edu.lich.algo;

public class LongestPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abccbdd";
		System.out.println(longestPalindrome(s));
	}
	
	 public static String longestPalindrome(String s) {
		 boolean[][] isPal = new boolean[s.length()][];
		 for(int j = 0; j < s.length();j++){
			 isPal[j]= new boolean[s.length()];
			 for(int i = 0; i <= j;i++) {
				 isPal[j][i] = false;
			 }
			 isPal[j][j] = true;
		 }
		 int maxI = 0;
		 int maxJ = 0;
		 for(int j = 0; j < s.length();j++){
			 for(int i = 0; i <= j;i++) {
				 if((s.charAt(i) == s.charAt(j)) && (j < i + 2 || isPal[i + 1][j - 1])){
					 isPal[i][j] = true;
					 if(j - i > maxJ - maxI){
						 maxJ = j;
						 maxI = i;
					 }
				 }
			 }
		 }
		 return s.substring(maxI, maxJ + 1);
	 }

}

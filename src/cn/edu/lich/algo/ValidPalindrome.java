package cn.edu.lich.algo;

public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vp.isPalindrome("race a car"));
	}
	
	public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() <= 0 || s.trim().length() <= 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
        	while(i < j && !isAlphabeticNumberic(s.charAt(i))) i++;
        	while(j > i && !isAlphabeticNumberic(s.charAt(j))) j--;
        	if(i >= j) return true;
        	if(!isEqual(s.charAt(i), s.charAt(j))) return false;
        	i++;
        	j--;
        }
        return true;
    }
	

	private boolean isAlphabeticNumberic(char c){
		return (c <= 'Z' && c >= 'A') ||
				(c <= 'z' && c >= 'a') ||
				(c <= '9' && c >= '0');
	}
	
	private boolean isEqual(char x, char y){
		return x == y ||
				(Math.abs(x - y) == 'a' - 'A');
	}
}

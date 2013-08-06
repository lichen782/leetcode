package cn.edu.lich.algo;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 * @author lich
 * {@link http://leetcode.com/onlinejudge} 
 *
 */
public class PalindromePartitionII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
		System.out.println(palindromCount(s, 0, s.length()-1) - 1);
	}
	
    public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return palindromCount(s, 0, s.length()-1) - 1;
    }
	
	public static int palindromCount(String s, int lo, int hi){
		if(lo == hi) return 1;
		if(lo > hi) return 0;
		int st = lo;
		int ed = lo;
		/** 
		 * judge says it is too slow...
		for(int i = lo + 1; i <= hi; i++){
			for(int j = lo;j<= i;j++){
				if(i - j <= ed-st)break;
				if(isPalindrom(s,j,i)){
					if(i - j > ed - st){
						ed = i;
						st = j;
					}
					break;
				}
			}
		}*/
		
		String[] suffix = new String[2 * (hi - lo + 1) + 1];
		String combined = s.substring(lo,hi+1) + "#" + reverse(s.substring(lo,hi+1));
		int[] lcs = new int[suffix.length];
		for(int i = 0; i < combined.length(); i++) {
			suffix[i] = combined.substring(i);
		}
		Arrays.sort(suffix);
		int maxLengthIdx = 0;
		for(int i = 1;i<suffix.length;i++) {
			if((suffix[i-1].contains("#") && !suffix[i].contains("#")) 
					|| (!suffix[i-1].contains("#") && suffix[i].contains("#"))){
				int length = Math.min(suffix[i-1].length(), suffix[i].length());
				int j = 0;
				for(j = 0; j < length; j++) {
					if(suffix[i-1].charAt(j) != suffix[i].charAt(j))break;
				}
				lcs[i] = j;
				if(lcs[maxLengthIdx] <= j && isPalindrom(suffix[i], 0, j - 1)){
					maxLengthIdx = i;
				}
			}
		}
		if(suffix[maxLengthIdx].contains("#")){
			st = suffix.length - suffix[maxLengthIdx].length() + lo;
			ed = st + lcs[maxLengthIdx] - 1;
		}else {
			st = suffix.length - suffix[maxLengthIdx-1].length() + lo;
			ed = st + lcs[maxLengthIdx] - 1;
		}
		
		return 1 + palindromCount(s,lo, st - 1) + palindromCount(s,ed + 1, hi);
	}
	
	private static boolean isPalindrom(String s, int st, int ed) {
		while(st < ed) {
			if(s.charAt(st) != s.charAt(ed)) return false;
			st++;
			ed--;
		}
		return true;
	}
	private static String reverse(String s) {
		char[] chs = new char[s.length()];
		for(int i = s.length() -1;i>=0;i--){
			chs[s.length()-1-i]=s.charAt(i);
		}
		return new String(chs);
	}
}

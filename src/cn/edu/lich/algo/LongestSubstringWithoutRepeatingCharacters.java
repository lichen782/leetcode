package cn.edu.lich.algo;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

	
	public static void main(String[] args){
		String s = "abcbaebcdef";
		System.out.println(lengthOfLongestSubstring(s));
	}
	
	public static int lengthOfLongestSubstring(String s) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
		int maxLength = 0;
		HashSet<Character> set = new HashSet<Character>();
		for(int i = 0; i < s.length();i++) {
			set.clear();
			for(int j = i; j >=0;j--) {
				if(!set.contains(s.charAt(j))){
					set.add(s.charAt(j));
				}else {
					
					break;
				}
			}
			if(set.size() > maxLength) {
				maxLength = set.size();
			}
		}
		return maxLength;
	}
}

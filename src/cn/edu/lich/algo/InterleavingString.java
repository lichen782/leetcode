package cn.edu.lich.algo;

public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "aa";
		String s2 = "ab";
		String s3 = "abaa";
		InterleavingString ils = new InterleavingString();
		System.out.println(ils.isInterleave2(s1, s2, s3));
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(s1.length() + s2.length() != s3.length()) return false;
		if(s1.equals("") || s2.equals("") || s3.equals("")) {
			if(s3.equals("")) return s1.equals("") && s2.equals("");
			else return s1.equals(s3) || s2.equals(s3);
		}
		if(s1.charAt(0) == s3.charAt(0)) {
			if(s2.charAt(0) != s3.charAt(0)) {
				return isInterleaveInternal(s1, s2, s3);
			}else {
				if(isInterleaveInternal(s1, s2, s3)) return true;
				else return isInterleaveInternal(s2, s1, s3);
			}
		}else if(s2.charAt(0) == s3.charAt(0)) return isInterleave(s2, s1, s3);
		else return false;
	}
	
	private boolean isInterleaveInternal(String s1, String s2, String s3){
		if(s1.equals("")) {
			return s2.equals("") && s3.equals("");
		}
		if(s1.equals(s3) && s2.endsWith("")) return true;
		int i1 = 0;
		int i2 = 0;
		int i3 = 0;
		if(s1.charAt(0) != s3.charAt(0)) return false;
		while(i1 < s1.length() && i2 < s2.length() && i3 < s3.length() &&
				s1.charAt(i1) == s3.charAt(i3)) {
			i1++;
			i3++;
			//如果这里s2也可以匹配s3，那么我们立马递归进行匹配
			if(s2.charAt(i2) == s3.charAt(i3) && isInterleaveInternal(s2.substring(i2), s1.substring(i1), s3.substring(i3)))
				return true;
		}
		//接下来开始匹配s2
		return isInterleaveInternal(s2, s1.substring(i1), s3.substring(i3));
		
	}

	public boolean isInterleave2(String s1, String s2, String s3){
		if(s1.length() + s2.length() != s3.length()) return false;
		boolean[][] matched = new boolean[s1.length() + 1][s2.length() + 1];
		matched[0][0] = true;
		for(int i1 = 1; i1 <= s1.length(); i1++){
			if(s3.charAt(i1-1) == s1.charAt(i1-1)) {
				matched[i1][0] = true;
			}else break;
		}
		for(int i2 = 1; i2 <= s2.length(); i2++){
			if(s3.charAt(i2 - 1) == s2.charAt(i2 - 1)) {
				matched[0][i2] = true;
			}else break;
		}
		
		for(int i1 = 1; i1 <= s1.length(); i1++){
			char c1 = s1.charAt(i1 - 1);
			for(int i2 = 1; i2 <= s2.length(); i2++){
				int i3 = i1 + i2;
				char c2 = s2.charAt(i2 - 1);
				char c3 = s3.charAt(i3 - 1);
				if(c1 == c3){
					matched[i1][i2] |= matched[i1 - 1][i2];
				}
				if(c2 == c3){
					matched[i1][i2] |= matched[i1][i2 - 1];
				}
			}
		}
		return matched[s1.length()][s2.length()];
	}
}

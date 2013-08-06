package cn.edu.lich.algo;

public class LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
	}
	
	public static String longestCommonPrefix(String[] strs){
		int i = 0;
		int minLength = Integer.MAX_VALUE;
		if(strs == null || strs.length == 0) return "";
		for(String str : strs){
			if(str.length() < minLength) minLength = str.length();
		}
		char[] chs = new char[minLength];
		while(true) {
			char c = ' ';
			for(String str : strs) {
				if(i < str.length()){
					if(c == ' '){
						c = str.charAt(i);
					}else if(str.charAt(i) != c){
						return new String(chs, 0, i);
					}
				}else return new String(chs,0,i);
			}
			chs[i++] = c;
		}
	}

}

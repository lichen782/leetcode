package cn.edu.lich.algo;

import java.util.HashMap;

public class ScrambleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("great", "rgtae"));
	}
	
	public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
       if(!isContainSameChars(s1, s2))return false;
       if(s1.equals(s2)) return true;
       for(int split = 1; split < s1.length(); split++){
    	   String s11 = s1.substring(0, split);
    	   String s12 = s1.substring(split);
    	   
    	   String s21 = s2.substring(0, split);
    	   String s22 = s2.substring(split);
    	   if(isScramble(s11, s21) && isScramble(s12, s22)) return true;
    	   
    	   s21 = s2.substring(0, s2.length() - split);
    	   s22 = s2.substring(s2.length() - split);
    	   if(isScramble(s11, s22) && isScramble(s12, s21)) return true;
       }
       return false;
    }
	
	private boolean isContainSameChars(String s1, String s2){
		if(s1.length() != s2.length()) return false;
		if(s1.equals(s2)) return true;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s1.length(); i++){
        	if(map.containsKey(s1.charAt(i))){
        		map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
        	}else map.put(s1.charAt(i), 1);
        }
        for(int i = 0; i < s2.length(); i++){
        	if(map.containsKey(s2.charAt(i))){
        		int c = map.get(s2.charAt(i));
        		if(c == 1) map.remove(s2.charAt(i));
        		else map.put(s2.charAt(i), c - 1);
        	}else return false;
        }
        return map.isEmpty();
	}

}

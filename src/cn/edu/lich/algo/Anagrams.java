package cn.edu.lich.algo;

import java.util.*;

public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(anagrams(new String[] {
				"hos","boo","nay","deb","wow","bop","bob",
				"brr","hey","rye","eve","elf","pup","bum",
				"iva","lyx","yap","ugh","hem","rod","aha",
				"nam","gap","yea","doc","pen","job","dis",
				"max","oho","jed","lye","ram","pup","qua",
				"ugh","mir","nap","deb","hog","let","gym",
				"bye","lon","aft","eel","sol","jab"}));
	}
	
	public static ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < strs.length; i++){
        	String key = getKey(strs[i]);
        	if(map.containsKey(key)){
        		int cnt = map.get(key);
        		cnt++;
        		map.put(key, cnt);
        	}else map.put(key, 1);
        }
        for(int i = 0; i < strs.length;i++){
        	String key = getKey(strs[i]);
        	if(map.get(key) > 1) result.add(strs[i]);
        }
        return result;
    }
	
	private static String getKey(String str){
		char[] chs = str.toCharArray();
		Arrays.sort(chs);
		return new String(chs);
	}

}

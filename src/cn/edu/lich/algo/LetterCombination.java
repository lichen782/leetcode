package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

	A mapping of digit to letters (just like on the telephone buttons) is given below.
	
	Input:Digit string "23"
	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author lich
 *
 */
public class LetterCombination {
	
	public static HashMap<Integer, String> digitalMaps;
	
	static{
		digitalMaps = new HashMap<Integer, String>();
		digitalMaps.put(2,"abc");
		digitalMaps.put(3,"def");
		digitalMaps.put(4,"ghi");
		digitalMaps.put(5,"jkl");
		digitalMaps.put(6,"mno");
		digitalMaps.put(7,"pqrs");
		digitalMaps.put(8,"tuv");
		digitalMaps.put(9,"wxyz");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(letterCombinations(""));
	}
	
	public static ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = null;
        if(digits == null || digits.length() == 0) {
        	result = new ArrayList<String>();
        	result.add("");
        	return result;
        }
        String[] sets = new String[digits.length()];
        for(int i = 0; i < digits.length(); i++){
        	sets[i] = digitalMaps.get(digits.charAt(i) - '0');
        }
        result = Generate(sets,0);
        return result;
	}
        
    private static ArrayList<String> Generate(String[] sets, int st){
    	ArrayList<String> result = new ArrayList<String>();
    	if(st == sets.length - 1) {
    		for(int i = 0; i < sets[st].length();i++){
    			result.add(new String(new char[]{sets[st].charAt(i)}));
    		}
    	}else if(st < sets.length - 1){
    		ArrayList<String> down = Generate(sets, st + 1);
    		for(int i = 0; i < sets[st].length();i++){
    			for(String suffix: down){
    				result.add(sets[st].charAt(i) + suffix);
    			}
    		}
    	}
    	return result;
    }
}

package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;

public class SubstringwithConcatenationofAllWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String S ="mississippi";
		String[] L = {"mississippis"};
		System.out.println(findSubstring3(S,L));
//		System.out.println(S.indexOf("foo", 4));
	}
	
	public static ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result = new ArrayList<Integer>();
        int lengthPerKey = L[0].length();
        int numberOfKeys = L.length;
        int i = 0;
        int k = 0;
        HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
        for(String str : L){
        	if(!map.containsKey(str)){
        		ArrayList<Integer> list = new ArrayList<Integer>();
        		list.add(k++);
        		map.put(str, list);
        	}else {
        		map.get(str).add(k++);
        	}
        	for(i = S.indexOf(str, i);i != -1 && i < S.length(); i = S.indexOf(str, i + lengthPerKey)){
        		result.add(i);
        	}
        }
        BitSet bitSet = new BitSet(numberOfKeys);
        Collections.sort(result);
        for(i = 0; i < result.size();i++){//remove dup
        	if(i > 0 && result.get(i) == result.get(i - 1)) result.remove(i--);
        }
        for(i = 0; i < result.size();i++){
        	int st = i;
        	bitSet.clear();
        	int j = 0;
        	int subStrIdx = result.get(st);
        	for(j = 0; j < numberOfKeys;j++){
        		if(S.length() - subStrIdx < (numberOfKeys - j)*lengthPerKey) break;
        		ArrayList<Integer> list = map.get(S.substring(subStrIdx, subStrIdx + lengthPerKey));
        		if(list == null)break;
        		k = 0;
        		while(k < list.size() && bitSet.get(list.get(k))) k++;
        		if(k < list.size())
        			bitSet.set(list.get(k));
        		else break;
        		subStrIdx += lengthPerKey;
        	}
        	if(bitSet.cardinality() != numberOfKeys) {
        		result.remove(i);
        		i--;
        	}
        	
        }
        
        return result;
    }
	
	public static ArrayList<Integer> findSubstring2(String S, String[] L) {
		int lengthPerKey = L[0].length();
        int numberOfKeys = L.length;
        BitSet bitSet = new BitSet(numberOfKeys);
		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int k = 0;
		for(String str : L){
        	if(!map.containsKey(str)){
        		ArrayList<Integer> list = new ArrayList<Integer>();
        		list.add(k++);
        		map.put(str, list);
        	}else {
        		map.get(str).add(k++);
        	}
		}
		
		for(int i = 0; i <= S.length() - numberOfKeys*lengthPerKey; i++){
			bitSet.clear();
			int j = 0;
			int st = i;
			for(j = 0; j < numberOfKeys;j++){
				if(S.length() - st < (numberOfKeys - j)*lengthPerKey) break;
        		ArrayList<Integer> list = map.get(S.substring(st, st + lengthPerKey));
        		if(list == null)break;
        		k = 0;
        		while(k < list.size() && bitSet.get(list.get(k))) k++;
        		if(k < list.size())
        			bitSet.set(list.get(k));
        		else break;
        		st += lengthPerKey;
			}
			if(bitSet.cardinality() == numberOfKeys) {
				result.add(i);
			}
		}
		return result;
	}
	
	public static ArrayList<Integer> findSubstring3(String S, String[] L) {
		int lengthPerKey = L[0].length();
        int numberOfKeys = L.length;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(String str : L){
        	if(!map.containsKey(str)){
        		map.put(str, 1);
        	}else {
        		map.put(str, map.get(str) + 1);
        	}
		}
		
		for(int i = 0; i <= S.length() - numberOfKeys*lengthPerKey; i++){
			int j = 0;
			int st = i;
			HashMap<String, Integer> wordsCount = new HashMap<String, Integer>(map);
			for(j = 0; j < numberOfKeys;j++){
				if(S.length() - st < (numberOfKeys - j)*lengthPerKey) break;
        		String sub = S.substring(st,st+lengthPerKey);
        		if(wordsCount.containsKey(sub)){
        			int times = wordsCount.get(sub);
        			if(times == 1) wordsCount.remove(sub);
        			else wordsCount.put(sub, times - 1);
        		}else break;
        		st += lengthPerKey;
			}
			if(j == numberOfKeys){
				result.add(i);
			}
		}
		return result;
	}
}

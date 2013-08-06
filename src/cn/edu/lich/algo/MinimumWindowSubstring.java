package cn.edu.lich.algo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;

public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String S = "ADOBECODEBANC";
		String T = "ABC";
		MinimumWindowSubstring ms = new MinimumWindowSubstring();
		System.out.println(ms.minWindow3(S, T));
	}
	
	/**************************start: lich solution O(N*M) *****************************************/
	public String minWindow(String S, String T) {
		//记录T中每一个字母出现的次数
        HashMap<Character, Integer> needToFill = new HashMap<Character, Integer>();
        //记录S中出现的T字母的位置
        HashMap<Character, LinkedList<Integer>> charAppearenceRecorder = new HashMap<Character, LinkedList<Integer>>();
        HashMap<Character, Integer> charBit = new HashMap<Character, Integer>();
        int bit_cnt = 0;
        for(int i = 0; i < T.length(); i++){
        	if(needToFill.containsKey(T.charAt(i))){
        		needToFill.put(T.charAt(i), needToFill.get(T.charAt(i)) + 1);
        	}else {
        		needToFill.put(T.charAt(i), 1);
        		charBit.put(T.charAt(i), bit_cnt++);
        		charAppearenceRecorder.put(T.charAt(i), new LinkedList<Integer>());
        	}
        }
        long upper = (1 << bit_cnt) - 1;//当bit_status == upper时，表示收集完所有的字母
        long bit_status = 0;
        int minWinStart = -1;
        int minWinEnd = S.length();
        for(int i = 0; i < S.length(); i++){
        	char c = S.charAt(i);
        	if(needToFill.containsKey(c)){
        		LinkedList<Integer> charList = charAppearenceRecorder.get(c);
        		charList.add(i);
        		if(charList.size() == needToFill.get(c)){
        			//字母c已经收集完毕，那么我们设置c对应的位
        			bit_status |= (1 << charBit.get(c));
        		}
        		if(charList.size() > needToFill.get(c) && bit_status != upper){
        			charList.removeFirst();
        		}
        		if(bit_status == upper){//收集到了合法的一个window
        			int start = startIndex(charAppearenceRecorder);
        			if(i - start <= minWinEnd - minWinStart){
        				minWinEnd = i;
        				minWinStart = start;
        			}
        			char charToShift = S.charAt(start);
        			charList = charAppearenceRecorder.get(charToShift);
        			charList.removeFirst();
        			bit_status -= (1 << charBit.get(charToShift));
        		}
        	}
        }
        
        return minWinStart == -1 ? "" : S.substring(minWinStart, minWinEnd + 1);
    }
	
	//how can we improve this complexity...
	private int startIndex(HashMap<Character, LinkedList<Integer>> charAppearenceRecorder){
		int min = Integer.MAX_VALUE;
		for(LinkedList<Integer> list : charAppearenceRecorder.values()){
			if(min > list.getFirst()){
				min = list.getFirst();
			}
		}
		return min;
	}
	/**************************end: lich solution *****************************************/
	
	
	/**************************start: leetcode O(NlogM) solution*******************************/
	public String minWindow2(String S, String T){
		HashMap<Character, Integer> needToFill = new HashMap<Character, Integer>();
		HashMap<Character, LinkedList<Integer>> charAppearenceRecorder = new HashMap<Character, LinkedList<Integer>>();
		SortedMap<Integer, Character> winMap = new TreeMap<Integer, Character>();
		int minWinStart = -1;
		int minWinEnd = S.length();
		for(int i = 0; i < T.length(); i++){
			if(!needToFill.containsKey(T.charAt(i))){
				needToFill.put(T.charAt(i), 1);
				charAppearenceRecorder.put(T.charAt(i), new LinkedList<Integer>());
			}else {
				needToFill.put(T.charAt(i), needToFill.get(T.charAt(i)) + 1);
			}
		}
		
		for(int i = 0; i < S.length(); i++){
			char c = S.charAt(i);
			if(needToFill.containsKey(c)){
				LinkedList<Integer> charList = charAppearenceRecorder.get(c);
				if(charList.size() < needToFill.get(c)){
					charList.add(i);
					winMap.put(i, c);
				}else {
					//如果某个字母收集过了，需要删除该字母出现的最小的index，保留靠右的部分
					int idxToErase = charList.removeFirst();
					winMap.remove(idxToErase);
					winMap.put(i, c);
					charList.add(i);
				}
				if(winMap.size() == T.length()){
					int start = winMap.firstKey();
					int end = winMap.lastKey();
					if(end - start < minWinEnd - minWinStart){
						minWinStart = start;
						minWinEnd = end;
					}
				}
			}
		}
		
		return minWinStart != -1 ? S.substring(minWinStart, minWinEnd + 1) : "";
	}
	/**************************end: leetcode O(NlogM) solution*******************************/
	
	/**************************start: leetcode O(N) solution*******************************/
	public String minWindow3(String S, String T){
		HashMap<Character, Integer> needToFill = new HashMap<Character, Integer>();
		HashMap<Character, Integer> hasFound = new HashMap<Character, Integer>();
		int count = 0;
		for(int i = 0; i < T.length(); i++){
			if(!needToFill.containsKey(T.charAt(i))){
				needToFill.put(T.charAt(i), 1);
				hasFound.put(T.charAt(i), 0);
			}else {
				needToFill.put(T.charAt(i), needToFill.get(T.charAt(i)) + 1);
			}
		}
		int minWinBegin = -1;
		int minWinEnd = S.length();
		for(int begin = 0, end = 0; end < S.length(); end++){
			char c = S.charAt(end);
			if(needToFill.containsKey(c)){
				hasFound.put(c, hasFound.get(c) + 1);
				if(hasFound.get(c) <= needToFill.get(c)){
					count++;
				}
				if(count == T.length()){
					while(!needToFill.containsKey(S.charAt(begin)) ||
							hasFound.get(S.charAt(begin)) > needToFill.get(S.charAt(begin))) {
						if(needToFill.containsKey(S.charAt(begin)) 
								&& hasFound.get(S.charAt(begin)) > needToFill.get(S.charAt(begin))){
							hasFound.put(S.charAt(begin), hasFound.get(S.charAt(begin)) - 1);
						}
						begin++;
					}
					if(end - begin < minWinEnd - minWinBegin){
						minWinEnd = end;
						minWinBegin = begin;
					}
				}
			}
		}
		return minWinBegin == -1 ? "" : S.substring(minWinBegin, minWinEnd + 1);
	}
	/**************************start: leetcode O(N) solution*******************************/
}

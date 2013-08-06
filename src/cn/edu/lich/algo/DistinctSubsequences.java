package cn.edu.lich.algo;

import java.util.HashMap;
import java.util.LinkedList;

public class DistinctSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DistinctSubsequences ds = new DistinctSubsequences();
		String S= "rabbbit";
		String T = "rabbit";
		System.out.println(ds.numDistinct(S, T));
	}
	
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<Character, LinkedList<Integer>> posMap = new HashMap<Character, LinkedList<Integer>>();
        for(int i = 0; i < T.length(); i++){
        	char c = T.charAt(i);
        	if(posMap.containsKey(c)){
        		posMap.get(c).addFirst(i + 1);
        	}else {
        		LinkedList<Integer> pos = new LinkedList<Integer>();
        		pos.add(i + 1);
        		posMap.put(c, pos);
        	}
        }
        int[] counting = new int[T.length() + 1];
        counting[0] = 1;
        for(int i = 0;i < S.length(); i++){
        	char c = S.charAt(i);
        	if(posMap.containsKey(c)){
        		for(int pos : posMap.get(c)){
        			counting[pos] += counting[pos - 1];
        		}
        	}
        }
        return counting[T.length()];
    }

}

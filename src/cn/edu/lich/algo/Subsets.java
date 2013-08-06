package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Subsets ss = new Subsets();
		int[] S = {1,2,3};
		System.out.println(ss.subsets(S));
	}
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        HashMap<Integer, Integer> bitMap = new HashMap<Integer, Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < S.length; i++){
        	bitMap.put(1<<i, S[i]);
        }
        for(int i = 0; i <= Math.pow(2, S.length) - 1; i++){
        	ArrayList<Integer> one_set = new ArrayList<Integer>();
        	int bit = i;
        	while(bit != 0){
            	int pos = bit & (-bit);
        		int k = bitMap.get(pos);
        		one_set.add(k);
        		bit -= pos;
        	}
    		result.add(one_set);
        }
        return result;
    }

}

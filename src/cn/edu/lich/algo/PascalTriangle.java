package cn.edu.lich.algo;

import java.util.ArrayList;

public class PascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		System.out.println(pt.generate(5));
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0) return result;
        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(1);
        result.add(one);
        if(numRows == 1) return result;
        one = new ArrayList<Integer>();
        one.add(1);
        one.add(1);
        result.add(one);
        if(numRows == 2) return result;
        for(int i = 2; i < numRows; i++){
        	one = new ArrayList<Integer>();
        	one.add(1);
        	for(int j = 1; j < i; j++){
        		ArrayList<Integer> last = result.get(i - 1);
        		int k = last.get(j - 1) + last.get(j);
        		one.add(k);
        	}
        	one.add(1);
        	result.add(one);
        }
        return result;
    }
}

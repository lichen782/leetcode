package cn.edu.lich.algo;

import java.util.ArrayList;

public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(2));
	}
	
	public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(n == 0){
			result.add(0);
			return result;
		}
        else {
        	ArrayList<Integer> down = grayCode(n - 1);
        	result.addAll(down);
        	for(int i = down.size() - 1; i >= 0; i--){
        		int k = down.get(i);
        		k += 1<< (n - 1);
        		result.add(k);
        	}
        }
        return result;
    }

}

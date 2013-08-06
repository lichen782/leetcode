package cn.edu.lich.algo;

import java.util.ArrayList;

public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		// Start typing your Java solution below
		// DO NOT write main() function
		for(int i = triangle.size() - 2; i >= 0; i--){
			for(int j = 0; j < triangle.get(i).size(); j++) {
				int down = Math.min(triangle.get(i + 1).get(j),
						triangle.get(i+1).get(j + 1));
				down += triangle.get(i).get(j);
				triangle.get(i).set(j, down);
			}
		}
		return triangle.get(0).get(0);
	}

}

package cn.edu.lich.algo;

import java.util.ArrayList;

public class PascalTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PascalTriangleII pt = new PascalTriangleII();
		System.out.println(pt.getRow(3));
	}

	public ArrayList<Integer> getRow(int rowIndex) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (rowIndex == 0) {
			ArrayList<Integer> zero = new ArrayList<Integer>();
			zero.add(1);
			return zero;
		} else if (rowIndex == 1) {
			ArrayList<Integer> one = new ArrayList<Integer>();
			one.add(1);
			one.add(1);
			return one;
		}else {
			ArrayList<Integer> pre = new ArrayList<Integer>();
			pre.add(1);
			pre.add(1);
			ArrayList<Integer> cur = new ArrayList<Integer>();
			for(int i = 2; i <= rowIndex; i++){
				cur = new ArrayList<Integer>();
				cur.add(1);
				for(int j = 1; j < i; j++){
					cur.add(pre.get(j - 1) + pre.get(j));
				}
				cur.add(1);
				pre = cur;
			}
			
			return cur;
		}
	}

}

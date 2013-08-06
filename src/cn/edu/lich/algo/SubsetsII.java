package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SubsetsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num1 = {1,2,3};
		int[] num2 = {1,2,2};
		SubsetsII ssii = new SubsetsII();
		System.out.println(ssii.subsetsWithDup(num1));
		System.out.println(ssii.subsetsWithDup(num2));
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		result.add(new ArrayList<Integer>());
		Stack<ArrayList<Integer>> newlyAddedLastTime = new Stack<ArrayList<Integer>>();
		int pre = num[0] - 1;
		for(int i = 0; i < num.length; i++) {
			if(num[i] != pre){
				newlyAddedLastTime.clear();
				for(ArrayList<Integer> list : result){
					ArrayList<Integer> newList = new ArrayList<Integer>(list);
					newList.add(num[i]);
					newlyAddedLastTime.add(newList);
				}
				result.addAll(newlyAddedLastTime);
			}else {
				ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
				for(ArrayList<Integer> list : newlyAddedLastTime){
					ArrayList<Integer> newList = new ArrayList<Integer>(list);
					newList.add(num[i]);
					tmp.add(newList);
				}
				result.addAll(tmp);
				newlyAddedLastTime.clear();
				newlyAddedLastTime.addAll(tmp);
			}
			pre = num[i];
		}
		return result;
    }
}

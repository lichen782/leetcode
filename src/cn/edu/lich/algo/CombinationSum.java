package cn.edu.lich.algo;

import java.util.*;

public class CombinationSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(combinationSum(new int[]{2,3,6,7}, 15));
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target){
		Arrays.sort(candidates);
		int k = binarySearch(candidates, target);
		if(k < 0) return new ArrayList<ArrayList<Integer>>();
		return combination(candidates, k, target);
	}
	
	private static ArrayList<ArrayList<Integer>> combination(int[] candidates, int curIdx, int target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		if(curIdx < 0 || target <= 0) return  result;
		for(int i = 0; i <= target/candidates[curIdx]; i++){
			ArrayList<ArrayList<Integer>> downThere = combination(candidates, curIdx - 1, target - i*candidates[curIdx]);
			if(downThere.size() > 0){
				for(ArrayList<Integer> dlist: downThere){
					result.add(addNOccurrenceOf(dlist, candidates[curIdx], i));
				}
			}
			if(i*candidates[curIdx] == target){
				ArrayList<Integer> singleLady = new ArrayList<Integer>();
				result.add(addNOccurrenceOf(singleLady, candidates[curIdx], i));
			}
		}
		return result;
	}
	
	private static ArrayList<Integer> addNOccurrenceOf(ArrayList<Integer> arrayList, int candidate, int n){
		while(n-- > 0){
			arrayList.add(candidate);
		}
		return arrayList;
	}
	
	private static int binarySearch(int[] array, int value){
		int lo = 0;
		int hi = array.length - 1;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(value > array[mid]) {
				lo = mid + 1;
			}else if(value < array[mid]){
				hi = mid - 1;
			}else return mid;
		}
		return lo - 1;
	}

}

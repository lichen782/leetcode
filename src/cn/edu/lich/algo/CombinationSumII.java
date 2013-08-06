package cn.edu.lich.algo;

import java.util.*;

public class CombinationSumII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[]{4,4,2,1,4,2,2,1,3}, 6));
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target){
		Arrays.sort(num);
		int k = binarySearch(num, target, 0, num.length - 1);
		ArrayList<ArrayList<Integer>> result = combination(num, k, target);
		HashSet<Integer> set = new HashSet<Integer>();
		for(int j = 0; j < result.size();j++){
			ArrayList<Integer> list = result.get(j);
			int key = keyOfArray(list);
			if(set.contains(key)){
				result.remove(list);
				j--;
			}else set.add(key);
		}
		
		return result;
	}
	
	private static int keyOfArray(ArrayList<Integer> array){
		int k = 0;
		for(int i = 0; i < array.size(); i++){
			k = k *10 + array.get(i);
		}
		return k;
	}
	
	private static ArrayList<ArrayList<Integer>> combination(int[] num, int curIdx, int target){
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(curIdx < 0 || target <= 0) return result;
		for(int i = 0; i < 2; i++){
			ArrayList<ArrayList<Integer>> limbo = combination(num, curIdx - 1, target - i*num[curIdx]);
			if(limbo.size() > 0){
				for(ArrayList<Integer> dlist : limbo){
					result.add(addNOccurrenceOf(dlist, num[curIdx], i));
				}
			}
			if(target == i*num[curIdx]){
				ArrayList<Integer> singleLady = new ArrayList<Integer>();
				result.add(addNOccurrenceOf(singleLady, num[curIdx], i));
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
	
	private static int binarySearch(int[] num, double value, int low, int high){
		int lo = low;
		int hi = high;
		while(lo <= hi){
			int mid = lo + (hi - lo) / 2;
			if(value > num[mid]){
				lo = mid + 1;
			}else if(value < num[mid]){
				hi = mid - 1;
			}else return mid;
		}
		return lo - 1;
	}

}

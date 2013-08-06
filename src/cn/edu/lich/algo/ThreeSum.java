package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

	Note:
	
	Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ? b ? c)
	The solution set must not contain duplicate triplets.
	    For example, given array S = {-1 0 1 2 -1 -4},
	
	    A solution set is:
	    (-1, 0, 1)
	    (-1, -1, 2)
 * @author lich
 *
 */
public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
		System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
		System.out.println(threeSum(new int[]{0,0}));
		System.out.println(threeSum(new int[]{-4,-2,-1}));
		System.out.println(threeSum(new int[]{}));
	}
	
	//Program Runtime: 784 milli secs
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		Arrays.sort(num);
        int i = 0;
        int j = num.length - 1;
        int firstNonNegativeIndex = -1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(j < 0 || num[i] > 0 || num[j] < 0) return result;//1.边界条件判断，如果没有非负数或者都是正数，返回空集合
        for(int k = 0; k < num.length;k++){
        	if(num[k] >= 0){
        		firstNonNegativeIndex = k;
        		break;
        	}
        }
        for(i = 0;i <= firstNonNegativeIndex;i++){
        	if(i > 0 && num[i] == num[i-1])continue;
        	for(j = num.length - 1; j> i + 1;j--) {
        		if(j <= num.length - 2 && num[j + 1] == num[j]) continue;
	        	int twoSum = num[i] + num[j];
	        	if(twoSum > 0) {
	        		int searchIdx = binarySearch(num, i+1,firstNonNegativeIndex - 1, -twoSum);
	        		if(searchIdx != -1){
	        			addTuple(result,new int[]{num[i],num[searchIdx],num[j]});
	        		}
	        	}else{
	        		int searchIdx = binarySearch(num, firstNonNegativeIndex,j-1, -twoSum);
	        		if(searchIdx != -1){
	        			addTuple(result,new int[]{num[i],num[searchIdx],num[j]});
	        		}
	        	}
        	}
        }
        return result;
    }
	
	public static ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < num.length - 2;i++){
			if(i > 0 && num[i] == num[i-1])continue;
			int j = i + 1;
			int k = num.length - 1;
			while(j < k){
				int twoSum = num[i] + num[j];
				if(twoSum + num[k] > 0){
					k--;
				}else if(twoSum + num[k] < 0){
					j++;
				}else {
					addTuple(result,new int[]{num[i],num[j],num[k]});
					j++;
					k--;
					while(num[j] == num[j - 1] && num[k]==num[k+1] && j < k){
						j++;
						k--;
					}
				}
			}
		}
		return result;
	}
	
	private static void addTuple(ArrayList<ArrayList<Integer>> result, int[] abc){
		ArrayList<Integer> tupl = new ArrayList<Integer>();
		for(int add : abc){
			tupl.add(add);
		}
		result.add(tupl);
	}
	
	private static int binarySearch(int[] array, int lo, int hi, int value){
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(value > array[mid]){
				lo = mid + 1;
			}else if(value < array[mid]){
				hi = mid - 1;
			}else return mid;
		}
		return -1;
	}
}

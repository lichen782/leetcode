package cn.edu.lich.algo;

import java.util.Arrays;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int[] result = twoSum(numbers, 9);
		System.out.println(result[0] + " " + result[1]);
		
	}
//	public static int[] twoSum(int[] numbers, int target) {
//	    // Start typing your Java solution below
//	    // DO NOT write main() function
//		for(int i = 0; i < numbers.length; i++){
//			int other = target - numbers[i];
//			for(int j = i + 1; j < numbers.length; j++){
//				if(numbers[j] == other)
//					return new int[]{i + 1, j + 1};
//			}
//		}
//		return new int []{};
//	        
//	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int[] ns = numbers.clone();
		Arrays.sort(ns);
		int i = 0;
		int j = numbers.length - 1;
		while(i < j) {
			if(ns[i] + ns[j] > target){
				j--;
			}else if(ns[i] + ns[j] < target){
				i++;
			}else{
				int one = IndexOf(numbers, ns[i]);
				int another = IndexOf(numbers, ns[j]);
				if(one == another) another++;
				return new int[]{Math.min(one, another), Math.max(one, another)};
			}
		}
		return new int[]{};
		
	}
	
	private static int IndexOf(int[] numbers, int value){
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] == value)return i + 1;
		}
		return -1;
	}

}

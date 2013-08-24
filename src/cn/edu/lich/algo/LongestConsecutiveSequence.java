package cn.edu.lich.algo;

import java.util.Arrays;
import java.util.HashMap;

public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new LongestConsecutiveSequence().longestConsecutive2(new int[]{0, 0}));
	}

	public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        int longestLength = 1;
        int curLength = 1;
        for(int i = 0; i < num.length - 1; i++)	{
        	int diff = num[i + 1] - num[i];
        	if(diff == 1) {
        		curLength++;
        		if(curLength > longestLength) {
        			longestLength = curLength;
        		}
        	}else if(diff != 0){
        		curLength = 0;
        	}
        }
        return longestLength;
    }
	
	public int longestConsecutive2(int[] num){
		//record the upper(or lower bound) and its consecutively related length;
		HashMap<Integer, Integer> boundLength = new HashMap<Integer, Integer>();
		int max = 1;
		for(int i = 0; i < num.length; i++){
			if(!boundLength.containsKey(num[i])) {
				boundLength.put(num[i], 1);
				if (boundLength.containsKey(num[i] - 1)) {
					max = Math.max(max, merge(boundLength, num[i] - 1, num[i]));
				}
				if (boundLength.containsKey(num[i] + 1)) {
					max = Math.max(max, merge(boundLength, num[i], num[i] + 1));
				}
			}
		}
		return max;
	}
	
	/**
	 * left = right - 1, they are neighbors.
	 * ..., left, right, .... 
	 * by finding this left and right, we can merge 2 ranges to one
	 * @param boundLength record the exist range, key is either upper and lower bound, value is the length
	 * @param left newly found left
	 * @param right newly found right, 
	 * @return newly merged range length;
	 */
	private int merge(HashMap<Integer, Integer> boundLength, int left, int right){
		int upper = right + boundLength.get(right) - 1;
		int lower = left - (boundLength.get(left) - 1);
		int length = upper - lower + 1;
		boundLength.put(upper, length);
		boundLength.put(lower, length);
		return length;
	}
}

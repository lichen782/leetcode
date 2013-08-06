package cn.edu.lich.algo;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * @author lich
 *
 */
public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
	}
	
	private static int threeSumClosest(int[] num, int target){
		Arrays.sort(num);
		int minCloset = Integer.MAX_VALUE;
		int minSum = 0;
		for(int i = 0; i < num.length - 2; i++){
			int j = i + 1;
			int k = num.length - 1;
			while(j < k){
				int threeSum = num[i] + num[j] + num[k];
				int abs = Math.abs(threeSum - target);
				if(threeSum > target) {
					k--;
				}else if(threeSum < target){
					j++;
				}else return target;
				if(minCloset > abs) {
					minCloset = abs;
					minSum = threeSum;
				}
			}
		}
		return minSum;
	}
}

package cn.edu.lich.algo;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] height = {5,4,3,2,1};
		int[] height2 = {1,3,7,10,4,2};
		LargestRectangleinHistogram lrh = new LargestRectangleinHistogram();
//		System.out.println(lrh.largestRectangleArea2(height));
		System.out.println(lrh.largestRectangleArea2(height2));
	}

	public int largestRectangleArea(int[] height) {
		// Start typing your Java solution below
		// DO NOT write main() function
		int[] min = new int[height.length];
		int maxArea = 0;
		for(int i = 0; i < height.length; i++){
			if(height[i] != 0 && maxArea/height[i] >= (height.length - i)) {
				continue;
			}
			for(int j = i; j < height.length; j++){
				if(i == j) min[j] = height[j];
				else {
					if(height[j] < min[j - 1]) {
						min[j] = height[j];
					}else min[j] = min[j-1];
				}
				int tentativeArea = min[j] * (j - i + 1);
				if(tentativeArea > maxArea) {
					maxArea = tentativeArea;
				}
			}
		}
		return maxArea;
	}
	
	public int largestRectangleArea2(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);
		while(i < h.length){
			if(stack.isEmpty() || h[stack.peek()] <= h[i]){
				stack.push(i++);
			}else {
				int t = stack.pop();
				maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
			}
		}
		return maxArea;
	}
}

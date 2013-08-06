package cn.edu.lich.algo;

public class ContainerWithMostWater {

	/**
	 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
	 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
	 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	 * Note: You may not slant the container.
	 * @param args
	 */
	public static void main(String[] args) {
		int[] h = {2,3,10,5,7,8,9};
		System.out.println(maxArea(h));
	}

	
	public static int maxArea(int[] height){
		int maxArea = 0;
		int i = 0;
		int j = height.length - 1;
		if(j <=0)return 0;
		while(i < j) {
			int area = area(height, i, j);
			if(height[i] < height[j]){
				i++;
				
			}else {
				j--;
			}
			if(area > maxArea) maxArea = area;
		}
		return maxArea;
	}
	
	//O(n^2)
//	 public static int maxArea(int[] height) {
//	     // Start typing your Java solution below
//	     // DO NOT write main() function
//		 int maxArea = 0;
//		 for(int i = 1; i < height.length; i++){
//			 if(height[i] == 0)continue;
//			 int maxPossibleIdx = i - maxArea/height[i];
//			 for(int j = 0; j < i && j <= maxPossibleIdx; j++) {
//				 int area = area(height,i,j);
//				 if(area > maxArea) {
//					 maxArea = area;
//				 }
//			 }
//		 }
//		 return maxArea;
//	 }
	 
	 private static int area(int[] height, int i, int j){
		 return (height[i] < height[j] ? height[i] : height[j]) * (i > j ? i - j : j - i);
	 }
}

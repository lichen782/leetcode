package cn.edu.lich.algo;


public class TrappingRainWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(trap2(new int[]{2,0,2}));
	}
	
	
	public static int trap(int[] A){
		int i = 0;
		int j = A.length - 1;
		int sumArea = 0;
		while(i + 1 < j){
			//首先找到两边都不是0的位置
			while(A[i] <= 0 && i < j)i++;
			while(A[j] <= 0 && i < j)j--;
			//然后数数当前行有多少蓝色方块，也是就0的个数啦。
			//同时记录最小值
			int min = Integer.MAX_VALUE;
			for(int k = i; k < j;k++){
				if(A[k] == 0) sumArea += 1;
				if(A[k] < min) min = A[k];
			}
			//为记录下一行做准备，消除俄罗斯方块。。。。
			int step = Math.max(min, 1);
			for(int k = i; k <= j; k++){
				if(A[k] > 0)A[k]-= step;
			}
		}
		return sumArea;
	}
	
	public static int trap2(int[] A){
		if(A.length <= 1) return 0;
		int curMaxHeight = 0;
		int water = 0;
		int mid = 0;
		for(int i = 0; i < A.length;i++){
			if(A[i] > A[mid]) mid = i;
		}
		
		for(int i = 0; i < mid; i++){
			if(A[i] < curMaxHeight){
				water += curMaxHeight - A[i];
			}else curMaxHeight = A[i];
		}
		
		curMaxHeight = 0;
		for(int i = A.length - 1; i > mid; i--){
			if(A[i] < curMaxHeight){
				water += curMaxHeight -A[i];
			}else curMaxHeight = A[i];
		}
		return water;
	}
	
//	public static int trap(int[] A) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//		if(A.length <= 1) return 0;
//		int preMaxIdx = 0;
//		int sumArea = 0;
//		int curArea = 0;
//		Stack<Integer> stack = new Stack<Integer>();
//		for(int i = 1; i < A.length; i++){
//			if(A[i - 1] > A[i]){
////				if(A[i - 1] > preMax){
////					if(preMax != 0) sumArea += contains(A, preMaxIdx, i - 1);
////					preMax = A[i - 1];
////					preMaxIdx = i - 1;
////				}
//			}else {
//				int k = i - 1;
//				while(A[k] < A[i] && k > preMaxIdx)k--;
//				curArea = contains(A, k, i);
//				if(A[i] >= A[preMaxIdx]){
//					if(A[preMaxIdx] != 0) sumArea += curArea;
//					preMaxIdx = i;
//					curArea = 0;
//					stack.clear();
//				}else {
//					stack.push(curArea);
//				}
//			}
//		}
//		
//		while(!stack.isEmpty()) sumArea += stack.pop();
//		return sumArea;
//        
//    }
//	
//	// i and j ranges an independent water area
//	private static int contains(int[] A, int i, int j){
//		if(j <= i + 1) return 0;
//		int curArea = (j - i - 1) * Math.min(A[i], A[j]);
//		for(int k = i + 1; k < j; k++){
//			curArea -= A[k];
//			if(curArea <= 0) return 0;
//		}
//		return curArea;
//	}
	
//	private static int binarySearch(int[] A, int lo, int hi, int value){
//		int l = lo;
//		int h = hi;
//		while(l <= h){
//			int mid = l + (h - l)/2;
//			if(value < A[mid]){
//				l = mid + 1;
//			}else if(value > A[mid]){
//				h = mid - 1;
//			}else return mid;
//		}
//		return hi - lo - h;
//	}

}

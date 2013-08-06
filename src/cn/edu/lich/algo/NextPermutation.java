package cn.edu.lich.algo;

import java.util.Arrays;

public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num={4,2,0,2,3,2,0};
		nextPermutation(num);
		for(int i : num){
			System.out.print(i);
		}
	}
	
	public static void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 1) return;
        int i = num.length - 2;
        while(i >=0 && num[i] >= num[i + 1]){
        	i--;
        }
        if(i < 0)Arrays.sort(num);
        else{
        	int idx = binarySearchDesc(num, i + 1, num.length - 1, num[i]);
        	swap(num, i,idx);
        	sort(num, i + 1, num.length - 1);
        }
    }
	
	private static void swap(int [] num, int i, int j){
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	
	//in a descend array, find a num that is just bigger than value(floor of value)
	private static int binarySearchDesc(int[] num, int from, int to, int value){
		int lo = from;
		int hi = to;
		while(lo <= hi){
			int mid = lo + (hi - lo)/2;
			if(value > num[mid]){
				hi = mid -1;
			}else if (value < num[mid]){
				lo = mid + 1;
			}else{
				while(num[mid]==value && mid > from)mid--;//skip same value
				return mid;
			}
		}
		return lo - 1;
	}
	
	private static void sort(int [] num, int from, int to){
		for(int i = from; i < to; i++){
			for(int j = i + 1; j >from && num[j] < num[j-1];j--){
				swap(num, j, j -1);
			}
		}
	}

}

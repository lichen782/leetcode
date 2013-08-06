package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = new int[]{1,1,1};
		System.out.print(permute(num));
	}
	
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] original = Arrays.copyOf(num, num.length);
        int[] nextPerm = null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i = 0; i < num.length;i++){
    		list.add(num[i]);
    	}
    	result.add(list);
        while(!Arrays.equals(original, (nextPerm = nextPermutation(num)))){
        	list = new ArrayList<Integer>();
        	for(int i = 0; i < num.length;i++){
        		list.add(nextPerm[i]);
        	}
        	result.add(list);
        }
        return result;
    }
	
	
	private static int[] reverse(int[] num, int from, int to){
		while(from < to){
			int tmp = num[from];
			num[from] = num[to];
			num[to] = tmp;
			from++;
			to--;
		}
		return num;
	}
	
	private static void swap(int[] num, int i, int j){
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
	
	//lexically
	private static int[] nextPermutation(int[] num){
		int i = num.length - 2;
		while(i >= 0 && num[i] >= num[i + 1]) i--;
		if(i < 0) return reverse(num, 0, num.length - 1);
		int j = num.length - 1;
		while(j > i && num[j] <= num[i]) j--;
		swap(num, i, j);
		return reverse(num, i+1, num.length - 1);
	}
	

}

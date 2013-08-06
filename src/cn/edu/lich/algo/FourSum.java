package cn.edu.lich.algo;

import java.util.*;

public class FourSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
	}
	
	 public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Arrays.sort(num);
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	        for(int i = 0; i < num.length - 3; i++){
	        	if(i > 0 && num[i] == num[i-1])continue;
	        	for(int j = i + 1; j < num.length - 2; j++){
	        		if(j > i + 1 && num[j] == num[j-1])continue;
	        		int l = j + 1;
	        		int h = num.length - 1;
	        		int twoSum = num[i] + num[j];
	        		while(l < h){
	        			int fourSum = twoSum + num[l] + num[h];
	        			if(fourSum > target){
	        				h--;
	        			}else if(fourSum < target){
	        				l++;
	        			}else{
	        				addTuple(result,new int[]{num[i],num[j],num[l],num[h]});
	    					l++;
	    					h--;
	    					while(num[l] == num[l - 1] && num[h]==num[h+1] && l < h){
	    						l++;
	    						h--;
	    					}
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

}

package cn.edu.lich.algo;

import java.util.ArrayList;

public class PermutationSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationSequence ps = new PermutationSequence();
		System.out.println(ps.getPermutation(4, 7));
	}
	
	public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int total = jiecheng(n);
		ArrayList<Integer> nums = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++){
			nums.add(i+1);
		}
		appendKthFrom(nums, total, k, sb);
		return sb.toString();
    }
	
	private void appendKthFrom(ArrayList<Integer> nums, int totalPer, int k, StringBuilder sb){
		if(nums.size() == 1){
			sb.append(nums.get(0));
			return;
		}
		int cnt_per_unit = totalPer/nums.size();
		int range =  k/cnt_per_unit + (k%cnt_per_unit == 0 ? 0 : 1);
		sb.append(nums.get(range - 1));
		nums.remove(range - 1);
		appendKthFrom(nums, cnt_per_unit, k%cnt_per_unit == 0 ? cnt_per_unit : k%cnt_per_unit, sb);
	}
	
	
	private static int jiecheng(int n){
		if(n == 1) return 1;
		else return n*jiecheng(n-1);
	}

}

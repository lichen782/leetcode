package cn.edu.lich.algo;

import java.util.ArrayList;

public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Combinations cmb = new Combinations();
		System.out.println(cmb.combine(4, 3));
	}
	
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		return generate(n,k);
    }
	
	private ArrayList<ArrayList<Integer>> generate(int n, int k){
		if(k == 1){
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			for(int i = 1; i <= n; i++){
				ArrayList<Integer> one = new ArrayList<Integer>();
				one.add(i);
				result.add(one);
			}
			return result;
		}
		if(n <= k){
			ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> one = new ArrayList<Integer>();
			for(int i = 1; i <=n; i++){
				one.add(i);
			}
			result.add(one);
			return result;
		}
		ArrayList<ArrayList<Integer>> result = generate(n - 1, k - 1);
		for(ArrayList<Integer> subArray : result){
			subArray.add(n);
		}
		result.addAll(generate(n - 1, k));
		return result;
	}

}

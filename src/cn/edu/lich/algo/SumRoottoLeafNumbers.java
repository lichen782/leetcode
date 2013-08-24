package cn.edu.lich.algo;

import java.util.ArrayList;

public class SumRoottoLeafNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(new SumRoottoLeafNumbers().sumNumbers(root));
	}
	
	public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> sr = numbers(root);
		int sum = 0;
		for(String s : sr){
			sum += Integer.parseInt(s);
		}
		return sum;
    }
	
	private ArrayList<String> numbers(TreeNode root) {
		ArrayList<String> result = new ArrayList<String>();
		if(root != null){
			int r = root.val;
			for(String n : numbers(root.left)){
				result.add(r + n);
			}
			for(String n : numbers(root.right)){
				result.add(r + n);
			}
			if(result.size() == 0) result.add(Integer.toString(r));
		}
		return result;
	}

}

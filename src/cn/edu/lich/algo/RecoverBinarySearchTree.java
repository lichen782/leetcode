package cn.edu.lich.algo;

import java.util.ArrayList;

public class RecoverBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		RecoverBinarySearchTree rbs = new RecoverBinarySearchTree();
		rbs.recoverTree(root);
		
	}
	
	private ArrayList<TreeNode> sequence;
	
	public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		sequence = new ArrayList<TreeNode>();
		inorderTraverse(root);
		int[] swaps = new int[2];
		swaps[0] = -1;
		swaps[1] = -1;
		int c = 0;
		for(int i = 1; i < sequence.size(); i++){
			if(sequence.get(i).val < sequence.get(i-1).val){
				swaps[c++] = i;
			}
		}
		if(swaps[1] == -1){
			swaps[1] = swaps[0];
		}
		swaps[0]--;
		int tmp = sequence.get(swaps[0]).val;
		sequence.get(swaps[0]).val = sequence.get(swaps[1]).val;
		sequence.get(swaps[1]).val = tmp;
    }	
	
	private void inorderTraverse(TreeNode x){
		if(x == null)return;
		inorderTraverse(x.left);
		sequence.add(x);
		inorderTraverse(x.right);
	}
}

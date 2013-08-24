package cn.edu.lich.algo;

import java.util.HashMap;

public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	private HashMap<TreeNode, Integer> onePathSum;
	private HashMap<TreeNode, Integer> midPathSum;
	
	public int maxPathSum(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root == null) return Integer.MIN_VALUE;
		return maxPathSumInternal(root);
	}
	
	private int maxPathSumInternal(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root.val;
		} else if (root.left != null && root.right != null) {
			int maxSum = Math.max(maxPathSumInternal(root.left),
					maxPathSumInternal(root.right));
			int left = fromRootToLeafMaxPath(root.left);
			int right = fromRootToLeafMaxPath(root.right);
			int midPathSum = (left > 0 ? left : 0) + root.val + (right > 0 ? right : 0);
			return Math.max(maxSum, midPathSum);
		}else {
			TreeNode subTree = root.left == null ? root.right : root.left;
			int maxSum = maxPathSumInternal(subTree);
			int onePathSum = fromRootToLeafMaxPath(subTree);
			int midPathSum = (onePathSum > 0 ? onePathSum : 0) + root.val;
			return Math.max(maxSum, midPathSum);
		}
	}
	
	private int fromRootToLeafMaxPath(TreeNode root){
		if(root.left == null && root.right == null) {
			return root.val;
		}else if(root.left != null && root.right != null){
			int maxDown = Math.max(fromRootToLeafMaxPath(root.left),
					fromRootToLeafMaxPath(root.right));
			if(maxDown > 0) return root.val + maxDown;
			else return root.val;
		}else {
			TreeNode subTree = root.left == null ? root.right : root.left;
			int maxDown = fromRootToLeafMaxPath(subTree);
			if(maxDown > 0) return root.val + maxDown;
			else return root.val;
		}
	}
}

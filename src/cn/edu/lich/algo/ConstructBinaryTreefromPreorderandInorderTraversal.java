package cn.edu.lich.algo;

import java.util.HashMap;
import java.util.Stack;

public class ConstructBinaryTreefromPreorderandInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] preorder = {1, 2};
//		int[] inorder = {2, 1};
//		ConstructBinaryTreefromPreorderandInorderTraversal cb = new ConstructBinaryTreefromPreorderandInorderTraversal();
////		TreeNode root = cb.buildTree(preorder, inorder);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(preorder.length == 0) return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++){
			inorderMap.put(inorder[i], i);
		}
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);
		int k = 1;
		while(k < preorder.length){
			TreeNode node = new TreeNode(preorder[k]);
			int inorderSqNo = inorderMap.get(preorder[k]);
			if(inorderSqNo < inorderMap.get(stack.peek().val)) {
				stack.peek().left = node;
			}else {
				TreeNode par = null;
				while(!stack.isEmpty() && inorderSqNo > inorderMap.get(stack.peek().val)) {
					par = stack.pop();
				}
				par.right = node;
			}
			stack.push(node);
			k++;
		}
		return root;
	}

}

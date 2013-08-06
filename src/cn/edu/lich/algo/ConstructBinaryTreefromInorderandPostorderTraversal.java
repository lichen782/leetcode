package cn.edu.lich.algo;

import java.util.HashMap;
import java.util.Stack;

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] inorder = {2, 1};
		int[] postorder = {2, 1};
		ConstructBinaryTreefromInorderandPostorderTraversal cb = new ConstructBinaryTreefromInorderandPostorderTraversal();
		cb.buildTree(inorder, postorder);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(postorder.length == 0) return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		HashMap<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++){
			inorderMap.put(inorder[i], i);
		}

		int k = postorder.length - 1;
		TreeNode root = new TreeNode(postorder[k]);
		stack.push(root);
		k--;
		while(k >= 0){
			TreeNode node = new TreeNode(postorder[k]);
			int seqInOrder = inorderMap.get(postorder[k]);
			if(seqInOrder > inorderMap.get(stack.peek().val)) {
				stack.peek().right = node;
			}else {
				TreeNode par = null;
				while(!stack.isEmpty() && seqInOrder < inorderMap.get(stack.peek().val)) {
					par = stack.pop();
				}
				par.left = node;
			}
			
			stack.push(node);
			k--;
		}
		return root;
	}
}

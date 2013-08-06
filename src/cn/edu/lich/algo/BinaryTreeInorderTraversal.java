package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.left.right = new TreeNode(5);
		BinaryTreeInorderTraversal btt = new BinaryTreeInorderTraversal();
		System.out.println(btt.inorderTraversal(root));
	}
	
	private ArrayList<Integer> sequence;
	private HashMap<TreeNode, Boolean> traverseMap;
	private Stack<TreeNode> stack;
	
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		sequence = new ArrayList<Integer>();
		traverseMap = new HashMap<TreeNode, Boolean>();
		stack = new Stack<TreeNode>();
		inorderIterative(root);
		return sequence;
    }
	
//	private void inorderInternal(TreeNode node){
//		if(node != null){
//			inorderInternal(node.left);
//			sequence.add(node.val);
//			inorderInternal(node.right);
//		}
//	}
	
	private void inorderIterative(TreeNode root){
		if(root != null){
			stack.push(root);
			traverseMap.put(root, false);
			while(!stack.isEmpty()){
				TreeNode node = stack.peek();
				if(node.left != null && !traverseMap.get(node)) {
					stack.push(node.left);
					traverseMap.put(node.left, false);
					traverseMap.put(node, true);
				}else {
					sequence.add(node.val);
					stack.pop();
					traverseMap.put(node, true);
					if(node.right != null){
						stack.push(node.right);
						traverseMap.put(node.right, false);
					}
				}
			}
		}
	}

	/***************************morris****************************/
	public ArrayList<Integer> inorderMorrisTraversal(TreeNode root){
		sequence = new ArrayList<Integer>();
		TreeNode current = root;
		TreeNode pre = null;
		while(current != null){
			if(current.left == null){
				sequence.add(current.val);
				current = current.right;
			}else {
				pre = current.left;
				//找到当前节点的前任，也就是它左子树的最右节点
				while(pre.right != null && pre.right != current){
					pre = pre.right;
				}
				if(pre.right == null){//我们遇到的左子树
					pre.right = current;
					current = current.left;
				}else {//说明pre.right == current，构成了一个环，说明之前已经遍历过了current的左子树，可以输出current了。
					pre.right = null;
					sequence.add(current.val);
					current = current.right;
				}
			}
		}
		return sequence;
	}
}

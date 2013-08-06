package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal bi = new BinaryTreeLevelOrderTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		System.out.println(bi.levelOrder(root));
	}
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null)return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        TreeNode first = root;
        while(!queue.isEmpty()) {
        	TreeNode node = queue.removeFirst();
        	if(node == first) {
        		ArrayList<Integer> oneLevel = new ArrayList<Integer>();
        		oneLevel.add(node.val);
        		for(TreeNode n : queue) {
        			oneLevel.add(n.val);
        		}
        		result.add(oneLevel);
        		first = null;
        	}
        	if(node.left != null) {
        		queue.addLast(node.left);
        		if(first == null) first = node.left;
        	}
        	if(node.right != null) {
        		queue.addLast(node.right);
        		if(first == null) first = node.right;
        	}
        }
        return result;
    }

	
}

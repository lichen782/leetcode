package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversalII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		LinkedList<ArrayList<Integer>> result = new LinkedList<ArrayList<Integer>>();
		if(root == null)return new ArrayList<ArrayList<Integer>>();
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
        		result.addFirst(oneLevel);
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
        ArrayList<ArrayList<Integer>> actual = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> level : result){
        	actual.add(level);
        }
        return actual;
	}
}

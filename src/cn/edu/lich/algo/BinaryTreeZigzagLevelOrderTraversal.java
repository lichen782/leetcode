package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null)return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        TreeNode first = root;
        int level = 0;
        while(!queue.isEmpty()) {
        	TreeNode node = queue.removeFirst();
        	if(node == first) {
        		ArrayList<Integer> oneLevel = new ArrayList<Integer>();
        		oneLevel.add(node.val);
        		for(TreeNode n : queue) {
        			oneLevel.add(n.val);
        		}
        		result.add(oneLevel);
        		if(level%2 != 0)Collections.reverse(oneLevel);
        		level++;
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

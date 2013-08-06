package cn.edu.lich.algo;

import java.util.LinkedList;

public class MaximumDepthofBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		int level = 0;
		if(root == null)return level;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        TreeNode first = root;
        while(!queue.isEmpty()) {
        	TreeNode node = queue.removeFirst();
        	if(node == first) {
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
        return level;
    }

}

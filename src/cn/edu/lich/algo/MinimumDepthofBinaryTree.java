package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.LinkedList;

public class MinimumDepthofBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(root == null)return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        TreeNode first = root;
        int level = 0;
        while(!queue.isEmpty()) {
        	TreeNode node = queue.removeFirst();
        	if(node == first) {
        		ArrayList<Integer> oneLevel = new ArrayList<Integer>();
        		oneLevel.add(node.val);
        		first = null;
        		level++;
        	}
        	if(node.left != null) {
        		queue.addLast(node.left);
        		if(first == null) first = node.left;
        	}
        	if(node.right != null) {
        		queue.addLast(node.right);
        		if(first == null) first = node.right;
        	}
        	if(node.left == null && node.right == null) return level;
        }
        return level;
    }

}

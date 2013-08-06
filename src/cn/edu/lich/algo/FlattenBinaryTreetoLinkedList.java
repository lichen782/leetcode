package cn.edu.lich.algo;

public class FlattenBinaryTreetoLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root != null){
        	flatten(root.right);
        	if(root.left != null){
        		TreeNode pre = root.left;
        		while(pre.right != null) {
        			pre = pre.right;
        		}
        		pre.right = root.right;
        		root.right = root.left;
        		root.left = null;
        		flatten(root.right);
        	}
        	
        }
    }

}

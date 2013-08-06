package cn.edu.lich.algo;

public class ValidateBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        boolean left = root.left == null || (max(root.left).val < root.val && isValidBST(root.left));
        boolean right = root.right == null || (min(root.right).val > root.val && isValidBST(root.right));
        return left && right;
    }
	
	private TreeNode min(TreeNode root){
		if(root != null){
			while(root.left != null){
				root = root.left;
			}
			return root;
		}
		return null;
	}
	
	private TreeNode max(TreeNode root){
		if(root != null){
			while(root.right != null) {
				root = root.right;
			}
			return root;
		}
		return null;
	}

}

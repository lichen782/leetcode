package cn.edu.lich.algo;


public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private boolean isBalanced;
	
	public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null) return true;
        isBalanced = true;
        height(root);
        return isBalanced;
    }
	
	
	private int height(TreeNode root){
		if(root == null) {
			return 0;
		}
		else {
			int left = height(root.left);
			int right = height(root.right);
			if(Math.abs(left - right) > 1) {
				isBalanced = false;
				return -1;
			}else {
				int h = Math.max(left, right) + 1;
				return h;
			}
		}
	}

}

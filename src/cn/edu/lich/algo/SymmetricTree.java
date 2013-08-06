package cn.edu.lich.algo;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
	public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		return root == null || isSymmetric(root.left, root.right);
    }
	
	private boolean isSymmetric(TreeNode left, TreeNode right){
		if(right == null && left == null) return true;
		else if(right != null && left != null){
			return right.val == left.val &&
					isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}else return false;
	}

}

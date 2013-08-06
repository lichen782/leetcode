package cn.edu.lich.algo;

public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(p == null && q == null){
			return true;
		}else {
			return p != null && q != null && p.val == q.val && 
					isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
    }

}

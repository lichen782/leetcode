package cn.edu.lich.algo;

public class PopulatingNextRightPointersinEachNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(root == null) return;
		if(root.left != null && root.right != null){
			TreeLinkNode pLeft = root.left;
			TreeLinkNode pRight = root.right;
			while(pLeft != null && pRight != null){
				pLeft.next = pRight;
				pLeft = pLeft.right == null ? pLeft.left : pLeft.right;
				pRight = pRight.left == null ? pRight.right : pRight.left;
			}
			connect(root.left);
			connect(root.right);
		}
		
    }
}

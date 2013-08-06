package cn.edu.lich.algo;

public class PopulatingNextRightPointersinEachNodeII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void connect(TreeLinkNode root) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if(root == null) return;
		TreeLinkNode preHead = root;
		TreeLinkNode preNode = preHead;
		TreeLinkNode head = null;
		TreeLinkNode tail = head;
		while(true){// i am so talented....
			while (preNode != null && preNode.left == null
					&& preNode.right == null) {
				preNode = preNode.next;
			}
			if (preNode == null)
				break;
			tail = head = preNode.left == null ? preNode.right : preNode.left;
			while(preNode != null){
				if(preNode.left != null) {
					tail.next = preNode.left;
					tail = tail.next;
				}
				if(preNode.right != null){
					tail.next = preNode.right;
					tail = tail.next;
				}
				preNode = preNode.next;
			}
			tail.next = null;
			preNode = preHead = head;
		}
		
	}
}
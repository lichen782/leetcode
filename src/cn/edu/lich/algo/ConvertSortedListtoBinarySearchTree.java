package cn.edu.lich.algo;

import java.util.ArrayList;

public class ConvertSortedListtoBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedListToBST(ListNode head) {
		// Start typing your Java solution below
		// DO NOT write main() function
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		while(head != null){
			arrayList.add(head.val);
			head = head.next;
		}
		int[] num = new int[arrayList.size()];
		for(int i = 0; i < num.length; i++){
			num[i] = arrayList.get(i);
		}
		return sortedArrayToBSTInternal(num, 0, num.length - 1);
	}
	
	private TreeNode sortedArrayToBSTInternal(int[] num, int from, int to){
    	if(from <= to){
    		int mid = from + (to - from)/2;
    		TreeNode root = new TreeNode(num[mid]);
    		TreeNode left = sortedArrayToBSTInternal(num, from, mid - 1);
    		TreeNode right = sortedArrayToBSTInternal(num, mid + 1, to);
    		root.left = left;
    		root.right = right;
    		return root;
    	}else return null;
    }

}

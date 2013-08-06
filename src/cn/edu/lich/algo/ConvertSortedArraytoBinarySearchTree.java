package cn.edu.lich.algo;

public class ConvertSortedArraytoBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = {2,3,4,7,9};
		ConvertSortedArraytoBinarySearchTree cb = new ConvertSortedArraytoBinarySearchTree();
		TreeNode root = cb.sortedArrayToBST(num);
		System.out.println(root);
	}
	
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0) return null;
        return  sortedArrayToBSTInternal(num, 0, num.length - 1);
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

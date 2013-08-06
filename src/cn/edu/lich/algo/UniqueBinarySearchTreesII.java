package cn.edu.lich.algo;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniqueBinarySearchTreesII ubst = new UniqueBinarySearchTreesII();
		ubst.generateTrees(2);
	}
	
	public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if (n == 0) {
			ArrayList<TreeNode> result = new ArrayList<TreeNode>();
			result.add(null);
			return result;
		}
		
		return generate(1, n);
    }
	
	private ArrayList<TreeNode> generate(int from, int to){
		ArrayList<TreeNode> result = new ArrayList<TreeNode>();
		if(from > to) return result;
		if(from == to) {
			result.add(new TreeNode(from));
			return result;
		}
		for(int root = from; root <= to; root++){
			ArrayList<TreeNode> left = generate(from, root - 1);
			ArrayList<TreeNode>	right = generate(root + 1, to);
			if(left.size() == 0 || right.size() == 0){
				if(left.size() == 0){
					for(TreeNode rightChild : right){
						TreeNode curRoot = new TreeNode(root);
						curRoot.left = null;
						curRoot.right = rightChild;
						result.add(curRoot);
					}
				}else{
					for(TreeNode leftChild : left){
						TreeNode curRoot = new TreeNode(root);
						curRoot.right = null;
						curRoot.left = leftChild;
						result.add(curRoot);
					}
				}
				continue;
			}else {
				for(TreeNode leftChild : left){
					for(TreeNode rightChild : right){
						TreeNode curRoot = new TreeNode(root);
						curRoot.left = leftChild;
						curRoot.right = rightChild;
						result.add(curRoot);
					}
				}
			}
		}
		return result;
	}

}

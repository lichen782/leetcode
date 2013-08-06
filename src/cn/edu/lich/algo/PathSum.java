package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.LinkedList;

public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	
    public boolean hasPathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root == null) return false;
    	if(root.left == null && root.right == null) {
    		return sum == root.val;
    	}else {
    		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    	}
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<ArrayList<Integer>> actualResult = new ArrayList<ArrayList<Integer>>();
    	ArrayList<LinkedList<Integer>> linkResult = pathSumInternal(root, sum);
    	for(LinkedList<Integer> down : linkResult){
    		ArrayList<Integer> onePath = new ArrayList<Integer>();
    		for(Integer nv : down){
    			onePath.add(nv);
    		}
    		actualResult.add(onePath);
    	}
    	return actualResult;
    }
    
    private ArrayList<LinkedList<Integer>> pathSumInternal(TreeNode root, int sum) {
    	ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
    	if(root == null) return result;
    	if(root.left == null && root.right == null) {//leaf
    		LinkedList<Integer> singleOne = new LinkedList<Integer>();
    		if(sum == root.val) {
    			singleOne.add(root.val);
    			result.add(singleOne);
    		}
    	}else {
    		for(LinkedList<Integer> down: pathSumInternal(root.left, sum - root.val)){
    			down.addFirst(root.val);
    			result.add(down);
    		}
    		for(LinkedList<Integer> down: pathSumInternal(root.right, sum - root.val)){
    			down.addFirst(root.val);
    			result.add(down);
    		}
    	}
    	return result;
    }

}

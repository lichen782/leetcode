package cn.edu.lich.algo;

import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestValidParentheses("()(()"));
	}
	
	private static int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		if(s.length() == 0) return 0;
        boolean[][] isValid = new boolean[s.length()][];//isValid[i][j] is true when from i to j, this is a valid parentheses expression
        int[][] longestValid = new int[s.length()][];//the longest length of valid expression between i and j
        for(int i = 0; i < s.length();i++){
        	isValid[i] = new boolean[s.length()];
        	longestValid[i] = new int[s.length()];
        }
        for(int j = 1; j < s.length();j++){
        	for(int i = j - 1; i >=0;i--){
        		int left = s.charAt(i);
        		int right = s.charAt(j);
        		int maxLength = 0;
        		if(left == '(' && right ==')'){
        			if(i + 1 == j) {
        				isValid[i][j] = true;
        				if(maxLength < 2) maxLength = 2;
        			}else {
        				if(isValid[i+1][j-1]){
        					isValid[i][j] = true;
        					if(maxLength < j - i + 1) maxLength = j - i + 1;
        				}else if(isValid[i][i+1] && isValid[j-1][j] && 
        						(isValid[i + 2][j - 2] ||  j - i == 3)){
        					isValid[i][j]=true;
        					if(maxLength < j - i + 1) maxLength = j - i + 1;
        				}else {
        					maxLength = Math.max(longestValid[i][j-1], longestValid[i+1][j]);
        					for(int k = i + 1; k < j;k++){
        						if(isValid[i][k] && isValid[k + 1][j]) {
        							maxLength = j - i + 1;
        							isValid[i][j]=true;
        							break;
        						}
        					}
        				}
        			}
        		}else {
        			if(left == '(' && right == '(' 
        					&& longestValid[i][j-1] > maxLength) maxLength = longestValid[i][j-1];
        			if(left == ')' && right == ')' 
        					&& longestValid[i+1][j] > maxLength)maxLength = longestValid[i+1][j];
        			if(left ==')' && right == '(' 
        					&& longestValid[i+1][j-1] > maxLength){
        				maxLength = longestValid[i+1][j-1];
        			}
        		}
        		longestValid[i][j] = maxLength;
        	}
        }
        return longestValid[0][s.length()-1];
    }
	
	public static int longestValidParentheses2(String s) {
	    int maxLen = 0, last = -1;
	    Stack<Integer> lefts = new Stack<Integer>();
	    for (int i=0; i<s.length(); ++i) {
	        if (s.charAt(i)=='(') {
	            lefts.push(i);
	        } else {
	            if (lefts.isEmpty()) {
	                // no matching left
	                last = i;
	            } else {
	                // find a matching pair
	                lefts.pop();
	                if (lefts.isEmpty()) {//有一个完整的valid的group。计算该group的长度
	                    maxLen = Math.max(maxLen, i-last);
	                } else {
	                	//栈内还有‘(',一个最外层完整的group还没有匹配完成，
	                	//但是通过查询下一个即将匹配还未匹配的"("的index来更新maxLen。
	                    maxLen = Math.max(maxLen, i-lefts.peek());
	                }
	            }
	        }
	    }
	    return maxLen;
	}
	
}

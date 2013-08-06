package cn.edu.lich.algo;

import java.util.*;

public class ValidParentheness {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isValid("]"));
	}
	
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') stack.push(s.charAt(i));
			else {
				if(stack.isEmpty()) return false;
				char c = stack.pop();
				if((c == '{' && s.charAt(i) == '}') ||
						(c == '(' && s.charAt(i) == ')')||
						(c == '[' && s.charAt(i) == ']')){
					continue;
				}else return false;
			}
		}
		return stack.isEmpty();
	}
}

package cn.edu.lich.algo;

import java.util.Stack;

public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("11", "1"));
		System.out.println(ab.addBinary("11", "11"));
		System.out.println(ab.addBinary("11", "10"));
	}
	
	public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = a.length() - 1;
        int j = b.length() - 1;
        if(i < j) return addBinary(b, a);
        Stack<Integer> stack = new  Stack<Integer>();
        int step = 0;
        int rmd = 0;
        int actual_value = 0;
        for(; j>=0; i--,j--){
        	int a_bit = (a.charAt(i) - '0');
        	int b_bit = (b.charAt(j) - '0');
        	actual_value = a_bit + b_bit + step;
        	rmd = actual_value % 2;
        	step = actual_value / 2;
        	stack.push(rmd);
        }
        while(i>=0){
        	int a_bit = (a.charAt(i) - '0');
        	actual_value = a_bit + step;
        	rmd = actual_value % 2;
        	step = actual_value / 2;
        	stack.push(rmd);
        	i--;
        }
        if(step > 0) stack.push(step);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
        	sb.append(stack.pop());
        }
        return sb.toString();
    }

}

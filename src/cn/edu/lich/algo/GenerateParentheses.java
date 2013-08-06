package cn.edu.lich.algo;

import java.util.ArrayList;

public class GenerateParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
	
	public static ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		generate(result, "",0,0,n);
		return result;
    }
	
	private static void generate(ArrayList<String> result, String prefix, int leftCount, int rightCount,int totalPairs){
		if(leftCount == totalPairs){
			for(int i = 0; i < totalPairs - rightCount;i++){
				prefix += ")";
			}
			result.add(prefix);
			return;
		}
		generate(result, prefix + "(", leftCount + 1, rightCount, totalPairs);
		if(leftCount > rightCount) generate(result, prefix +")", leftCount, rightCount + 1,totalPairs);
	}

}

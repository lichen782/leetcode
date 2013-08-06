package cn.edu.lich.algo;

import java.util.ArrayList;

public class TextJustification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//		String[] words = {""};
		String[] words = {"Here","is","an","example","of","text","justification."};
//		String[] words = {"What","must","be","shall","be."};
		TextJustification tj = new TextJustification();
		ArrayList<String> result = tj.fullJustify(words,16);
		for(String str : result){
			System.out.println(str);
		}
	}
	
	// Each word is guaranteed not to exceed L in length.
	public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
		ArrayList<String> result = new ArrayList<String>();
		String[] words_copy = new String[words.length + 1];
		for(int i = 0; i < words.length; i++){
			words_copy[i] = words[i];
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < L; i++){
			sb.append(" ");
		}
		words_copy[words.length] = sb.toString();
        int accumulatedLength = 0;
        int first = 0;
        for(int i = 0; i < words_copy.length; i++){
        	accumulatedLength += ((i == first ? 0 : 1) + words_copy[i].length());
        	if(accumulatedLength > L){
        		//previous one is last word 
        		//first ~ i - 1
        		accumulatedLength -= 1 + words_copy[i].length();
        		int available_spaces = L - accumulatedLength + i - 1 - first;
        		int spaces_per_unit = i - first - 1 == 0 ? 
        								available_spaces : 
        								available_spaces/(i - first - 1);
        		int spaces_reminder = i - first - 1 == 0 ? 
        				0 : available_spaces % (i - first - 1);
        		if(i == words_copy.length - 1){
        			spaces_per_unit = 1;
        			spaces_reminder = 0;
        		}
        		sb = new StringBuilder();
        		for(int j = first; j <= i - 1; j++){
        			sb.append(words_copy[j]);
        			if(available_spaces > 0){
	        			for(int k = 0; k < spaces_per_unit; k++){
	        				sb.append(" ");
	        			}
	        			available_spaces -= spaces_per_unit;
        			}
        			if(spaces_reminder > 0){
        				sb.append(" ");
        				spaces_reminder--;
        				available_spaces--;
        			}
        		}
        		if(i == words_copy.length - 1){
        			while(available_spaces > 0){
        				sb.append(" ");
        				available_spaces--;
        			}
        		}
        		result.add(sb.toString());
        		first = i;
        		accumulatedLength =  words_copy[i].length();
        	}
        }
        return result;
    }

}

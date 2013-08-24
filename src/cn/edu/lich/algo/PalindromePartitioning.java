package cn.edu.lich.algo;

import java.util.ArrayList;

public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromePartitioning pp = new PalindromePartitioning();
		System.out.println(pp.partition("aab"));
	}

	private ArrayList<ArrayList<String>>[] partitions;
	@SuppressWarnings("unchecked")
	public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
		partitions = new ArrayList[s.length()];
		
		for(int i = 0; i < s.length(); i++){
			partitions[i] = new ArrayList<ArrayList<String>>();
			if(i == 0){
				ArrayList<String> par = new ArrayList<String>();
				par.add(new String(new char[]{s.charAt(i)}));
				partitions[i].add(par);
			}
			else {
				//first of all, s[i] can combine all previous partitions
				for(ArrayList<String> par : partitions[i - 1]){
					ArrayList<String> pp = new ArrayList<String>(par);
					pp.add(new String(new char[]{s.charAt(i)}));
					partitions[i].add(pp);
				}
				for(int j = 0; j <= i - 1; j++){
					if(isPalindrome(s, j, i)){
						if(j > 0){
							for(ArrayList<String> par : partitions[j - 1]) {
								ArrayList<String> p = new ArrayList<String>(par);
								p.add(s.substring(j, i + 1));
								partitions[i].add(p);
							}
						}else {
							ArrayList<String> p = new ArrayList<String>();
							p.add(s.substring(0, i + 1));
							partitions[i].add(p);
						}
					}
				}
			}
		}
		
		return partitions[s.length() - 1];
    }
	private boolean isPalindrome(String s, int st, int end) {
		while(st < end){
			if(s.charAt(st) != s.charAt(end)) return false;
			st++;
			end--;
		}
		return true;
	}
}

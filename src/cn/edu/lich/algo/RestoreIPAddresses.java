package cn.edu.lich.algo;

import java.util.ArrayList;

public class RestoreIPAddresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "0279245587303";
		RestoreIPAddresses ra = new RestoreIPAddresses();
		System.out.println(ra.restoreIpAddresses(s));
	}
	
	private ArrayList<String> addresses;
	
	public ArrayList<String> restoreIpAddresses(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		addresses = new ArrayList<String>();
		partialRestoreAddr(s, 0, "", 4);
		return addresses;
	}
	
	private void partialRestoreAddr(String s, int start, String prefix, int count){
		if(start >= s.length()) return;
		if(count < 0 || count > 4) return;
		String remaining = s.substring(start);
		int length = remaining.length();
		if(count == 1 && length <= 3 && length >= 1){
			int k = Integer.parseInt(remaining);
			if((k >= 0 && k < 10 && length == 1) ||
					(k >= 10 && k < 100 && length == 2) ||
						(k >= 100 && k <= 255 && length == 3)){
				addresses.add(prefix + remaining);
			}
			return;
		}else{
			partialRestoreAddr(s, start + 1, prefix + s.charAt(start) + '.', count - 1);
			int step = start + 2;
			if(step <= s.length()){
				int k = Integer.parseInt(s.substring(start, step));
				if(k >= 10 && k < 100){
					partialRestoreAddr(s, step, prefix + s.substring(start, start + 2) + '.', count - 1);
				}
				step++;
				if(step <= s.length()){
					k = Integer.parseInt(s.substring(start, step));
					if(k >= 100 && k <= 255){
						partialRestoreAddr(s, step, prefix + s.substring(start, start + 3) + '.', count - 1);
					}
				}
			}
		}
	}

}

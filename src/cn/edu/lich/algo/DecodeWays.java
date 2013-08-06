package cn.edu.lich.algo;

public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings2("27"));
	}
	
	public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null) return 0;
        if(s.length() == 0) return 0;
        if(s.startsWith("0")) return 0;
        if(s.length() == 1 || s.length() == 2){
        	int k = Integer.parseInt(s);
        	if(s.length() == 1){
        		if(k != 0) return 1;
        		else return 0;
        	}else {
        		int hi = k / 10;
        		int lo = k % 10;
        		if(k >= 11 && k <= 26 && lo != 0) return 2;
        		if(hi == 0) return 0;
        		if(lo == 0) {
        			if(hi < 3) return 1;
        			else return 0;
        		}
        		else return 1;
        	}
        }else {
        	int first = numDecodings(s.substring(1));
        	int sed_map = Integer.parseInt(s.substring(0,2));
        	if(sed_map >= 1 && sed_map <= 26) return first + numDecodings(s.substring(2));
        	else return first;
        }
    }
	
	public int numDecodings2(String s){
		if (s == null)
			return 0;
		if (s.length() == 0)
			return 0;
		if (s.startsWith("0"))
			return 0;
		int[] cost = new int[s.length()];
		
		int k = Integer.parseInt(s.substring(s.length() - 1));
		if(k == 0) cost[s.length() - 1] = 0;
		else cost[s.length() - 1] = 1;
		
		if(s.length() >= 2) {
			k = Integer.parseInt(s.substring(s.length() - 2));
			int c = 0;
			int hi = k / 10;
    		int lo = k % 10;
    		if(k >= 11 && k <= 26 && lo != 0) c = 2;
    		else if(hi == 0) c = 0;
    		else if(lo == 0) {
    			if(hi < 3) c = 1;
    			else c = 0;
    		}
    		else c = 1;
    		cost[s.length() - 2] = c;
		}
		
		for (int i = s.length() - 3; i >= 0; i--) {
			if(s.charAt(i) == '0') cost[i] = 0;
			else {
				int sed_map = Integer.parseInt(s.substring(i,i + 2));
				if(sed_map >= 1 && sed_map <= 26) cost[i] = cost[i + 1] + cost[i + 2];
				else cost[i] = cost[i+1];
			}
		}
		
		return cost[0];
	}

}

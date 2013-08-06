package cn.edu.lich.algo;

public class SqrtX {

	private static final int MAX_HIGHER_BONDER = 46340;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SqrtX sx = new SqrtX();
		System.out.println(sx.sqrt(2147483647));
		System.out.println(46340 * 46340);
		System.out.println(Math.sqrt(Integer.MAX_VALUE));
	}
	
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int lo = 0;
    	int hi = Math.min(MAX_HIGHER_BONDER, x);
    	while(lo <= hi){
    		int mid = lo + (hi - lo) / 2;
    		int value = mid * mid;//overflow...
    		if(value > x) {
    			hi = mid - 1;
    		}else if(value < x){
    			lo = mid + 1;
    		}else return mid;
    	}
    	return lo - 1;
    }

}

package cn.edu.lich.algo;

public class NQueensII {

	private int cnt;
	private int upper;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new NQueensII().totalNQueens(4));
		
//		}
	}
	
	public int totalNQueens(int n){
		cnt = 0;
	    upper = (1<<n)-1 ;
	    Queen(0,0,0);
	    return cnt;
	}
	
	//为啥说大牛niub呢，看看我下面那个，再对比ld和rd，人大牛一眼就看出来了，没必要保存
	//所有对角线信息啊。下一个状态，完全由当前状态决定！！
	private void Queen(int row, int ld, int rd){//ld, left 对角线; rd, right 对角线
		 int pos, p;
		 if(row!=upper)
	     {
			 //so pos in binary is like, under current row/ld/rd restriction, what is available slot to put Q
	         pos = upper & (~(row | ld |rd));
	         while(pos!=0)//available is 1
	         {
	             p = pos & (-pos);//from right to left, the first "1" in pos
	             //now, we occupy the most right available position
	             pos = pos - p;//now take this available as ”Q“，pos kind of like a available slot marker
	             Queen(row+p,(ld+p)<<1,(rd+p)>>1);
	         }
	     }
         else ++cnt;
	}
	
	
//	public static int  totalNQueens(int n) {
//        // Start typing your Java solution below
//        // DO NOT write main() function
//		int cur_row_status = 0;
//		int[] count = new int[1];
//		HashMap<Integer, Boolean> left_digra_status = new HashMap<Integer, Boolean>();
//		HashMap<Integer, Boolean> right_digra_status = new HashMap<Integer, Boolean>();
//		collectSolutions(cur_row_status, left_digra_status, right_digra_status, 0, n, count);
//		return count[0];
//    }
//	
//    private static void collectSolutions(int cur_row_status, 
//    		HashMap<Integer, Boolean> left_digra_status, HashMap<Integer, Boolean> right_digra_status, 
//    		int row, int n, int[] count){
//    	if(row == n) {
//    		count[0]++;
//    		return;
//    	}
//    	int avail = available(cur_row_status, left_digra_status,right_digra_status, row, n);
//    	for(int i = 0; i < n; i++){
//    		if(!isSet(avail, i)){
//    			left_digra_status.put(row + i, true);
//    			right_digra_status.put(row - i, true);
//    			collectSolutions(set(cur_row_status, i), left_digra_status, right_digra_status, row + 1, 
//    					n, count);
//    			left_digra_status.put(row + i, false);
//    			right_digra_status.put(row - i, false);
//    		}
//    	}
//    }
//    
//    private static int available(int cur_row_status, 
//    		HashMap<Integer, Boolean> left_digra_status, HashMap<Integer, Boolean> right_digra_status, int row, int n){
//    	int avail = cur_row_status;
//    	for(int j = 0; j < n; j++){
//    		if((left_digra_status.containsKey(row + j) && left_digra_status.get(row + j))
//    				|| (right_digra_status.containsKey(row - j) && right_digra_status.get(row - j))) avail = set(avail, j);
//    	}
//    	return avail;
//    }
//    
//    
//    private static boolean isSet(int value, int bit){
//    	return (value >> bit) % 2 != 0;
//    }
//    
//    private static int set(int value, int bit){
//    	value |= 1<<bit;
//    	return value;
//    }

}

package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {

	private int upper;
	private int size;
	private String oneRow;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NQueens nqueen = new NQueens();
		for(String[] rows : nqueen.solveNQueensII(4)){
			System.out.println();
			for(String row : rows){
				System.out.println(row);
			}
		}
		
//		System.out.println(totalNQueens(12));
	}
	
    public static ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<int[]> result = new ArrayList<int[]>();
    	ArrayList<String[]> solutions = new ArrayList<String[]>();
    	int[] board = new int[n];
    	collectSolutions(board, 0, result);
    	StringBuilder sb = null;
    	for(int[] solution : result){
    		String[] ss = new String[n];
    		for(int i = 0; i < n; i++){
    			sb = new StringBuilder();
    			for(int j = 0; j < n; j++){
    				sb.append(isSet(solution[i], j) ? 'Q': '.');
    			}
    			ss[i] = sb.toString();
    		}
    		solutions.add(ss);
    	}
    	return solutions;
    }
    
    public static int  totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	ArrayList<int[]> result = new ArrayList<int[]>();
    	int[] board = new int[n];
        collectSolutions(board, 0, result);
        return result.size();
    }
    
    private static void collectSolutions(int[] board, int row, ArrayList<int[]> result){
    	if(row == board.length) {
    		result.add(Arrays.copyOf(board, board.length));
    	}
    	int avail = available(board, row);
    	for(int i = 0; i < board.length; i++){
    		if(!isSet(avail, i)){
    			board[row] = 1 << i;
    			collectSolutions(board, row + 1, result);
    			board[row] = 0;
    		}
    	}
    }
    
    private static int available(int[] board, int row){
    	int avail = 0;
    	for(int i = 0; i < row; i++){
    		avail |= board[i];
    	}
    	for(int j = 0; j < board.length;j++){
    		if(!isSet(avail, j)) {
    			for(int il = row - 1, jl = j - 1; il >=0 && jl >=0; il--,jl--){
    				if(isSet(board[il], jl)){
    					avail = set(avail, j);
    					break;
    				}
    			}
    		}
    		if(!isSet(avail, j)) {
    			for(int il = row - 1, jl = j + 1; il >=0 && jl < board.length; il--,jl++){
    				if(isSet(board[il], jl)){
    					avail = set(avail, j);
    					break;
    				}
    			}
    		}
    	}
    	return avail;
    }
    
    private static boolean isSet(int value, int bit){
    	return (value >> bit) % 2 != 0;
    }
    
    private static int set(int value, int bit){
    	value |= 1<<bit;
    	return value;
    }
    
    /**********************************华丽的分割线***************************************************/
    /**********************************what is niubility********************************************/
    
    public ArrayList<String[]> solveNQueensII(int n) {
    	this.size = n;
    	upper = (1 << n) - 1;
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < size; i++){
    		sb.append('.');
    	}
    	oneRow = sb.toString();
    	ArrayList<String[]> result = new ArrayList<String[]>();
    	ArrayList<String> board = new ArrayList<String>();
    	Queen(0,0,0, result, board);
    	return result;
    }
    
    private void Queen(int row, int ld, int rd, ArrayList<String[]> result, ArrayList<String> board){//ld, left 对角线; rd, right 对角线
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
	             StringBuilder sb = new StringBuilder(oneRow);
	             for(int i = 0; i < size; i++){
	            	 if(isSet(p, i)){
	            		 sb.setCharAt(i, 'Q');
	            		 break;
	            	 }
	             }
	             board.add(sb.toString());
	             Queen(row+p,(ld+p)<<1,(rd+p)>>1, result, board);
	         }
	     }
        else{
        	String[] boards = new String[board.size()];
        	result.add(board.toArray(boards));
        	//board.clear();
        }
		if(board.size() > 0)
			board.remove(board.size() - 1);
	}

}

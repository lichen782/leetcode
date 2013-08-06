package cn.edu.lich.algo;

public class Sudoku {

	private static final int SIZE = 9;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] boards ={"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6",".6....28.","...419..5","....8..79"};
		char[][] board = toBoard(boards);
		print(board);
		System.out.println("solving...");
		if(isValidSudoku(board)){
			solveSudoku(board);
			print(board);
		}
	}

	 public static boolean isValidSudoku(char[][] board) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        boolean[] set = new boolean[SIZE];
	        for(int i = 0; i < SIZE; i++){
	        	clear(set);
	        	if(!isValidRow(board, set, i)) return false;
	        	clear(set);
	        	if(!isValidCol(board, set, i)) return false;
	        	clear(set);
	        	if(!isValidGrid(board, set, i)) return false;
	        }
	        return true;
	 }
	 
	 public static void solveSudoku(char[][] board) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	     if(solve(board, 0,0)) {
	    	 System.out.println("This can be solved");
	     }else {
	    	 System.out.println("This can't be solved");
	     }
	 }
	 
	 public static char[][] toBoard(String[] boards){
		 char[][] board = new char[SIZE][];
		 for(int i = 0; i < SIZE; i++){
			 board[i] = new char[SIZE];
			 for(int j = 0; j < SIZE; j++){
				 board[i][j] = boards[i].charAt(j);
			 }
		 }
		 return board;
	 }
	 
	 public static void print(char[][] board){
		 System.out.println();
		 for(int i = 0; i < SIZE; i++){
			 for(int j = 0; j < SIZE; j++){
				 System.out.print(board[i][j] + " ");
			 }
			 System.out.println();
		 }
	 }
	 
	 /**
	  * 该函数假设从board[0][0]到
	  * board[row][col]之前的所有
	  * 格子都已经添满并且构成一个合理的board
	  * @param board 棋盘
	  * @param row 当前需要填充的cell的row
	  * @param col 当前需要填充的cell的col
	  * @return
	  */
	 private static boolean solve(char[][]board, int row, int col){
		int nextCol = (col + 1) % SIZE;					//下一个需要填充的格子的列号
		int nextRow = col == SIZE-1 ? row + 1 : row;	//下一个需要填充的格子的行号
		boolean[] set = new boolean[SIZE];				//记录当前格子可用的数字
		if(board[row][col] == '.') {
			scanColRowGrid(board, row, col, set);
			for(int i = 0; i < SIZE; i++){
				if(!set[i]){
					board[row][col] = (char)('1' + i);
					if(nextRow == SIZE) return true;
					if(solve(board, nextRow, nextCol)) return true;
					//else try next available number in this cell...
				}
			}
			board[row][col] = '.';						//一定要恢复这个值
			return false;
		}else {
			if(nextRow == SIZE) return true;
			return solve(board, nextRow, nextCol);
		}
	 }
	 
	 /**
	  * 决定board[row][col]可填写的数字
	  * @param board
	  * @param row
	  * @param col
	  * @param set 当函数返回时，set[i]为false表明数字i+1可以填写到棋盘中。
	  * @return
	  */
	 private static boolean[] scanColRowGrid(char[][] board, int row, int col, boolean[] set){
		 for(int i = 0; i < SIZE; i++){
			 if(board[row][i] >= '1' && board[row][i] <= '9') {
				 set[board[row][i] - '1'] = true;
			 }
		 }
		 for(int i = 0; i < SIZE; i++){
			 if(board[i][col] >= '1' && board[i][col] <= '9') {
				 set[board[i][col] - '1'] = true;
			 }
		 }
		 int grid = getGrid(row, col);
		 int st_row = 3 * (grid / 3);
		 int st_col = 3 * (grid % 3);
		 for(int i = 0; i < 3; i++){
			 for(int j = 0; j < 3; j++){
				 char c = board[st_row + i][st_col + j];
				 if(c >= '1' && c <= '9') {
					 set[c - '1'] = true;
				 }
			 }
		 }
		 return set;
	 }
	 
	 /**
	  * 通过行号和列号查询该格子所在的3x3格
	  * @param row
	  * @param col
	  * @return 0～8的数字，代表从左到右从上到下的3x3格标号
	  */
	 private static int getGrid(int row, int col){
		return 3 * (row / 3) + col / 3;
	 }
	 
	 private static void clear(boolean[] set){
		 for(int i = 0; i < SIZE;i++){
			 set[i] = false;
		 }
	 }
	 
	 private static boolean isValidRow(char[][] board, boolean[] set, int row) {
		 //clear(set);
		 for(int i = 0; i < SIZE; i++){
			 if(board[row][i] >= '1' && board[row][i] <= '9') {
				 if(set[board[row][i] - '1']) return false;
				 else set[board[row][i] - '1'] = true;
			 }else if(board[row][i] != '.') return false;
		 }
		 return true;
	 }
	 
	 private static boolean isValidCol(char[][] board, boolean[] set, int col){
		 //clear(set);
		 for(int i = 0; i < SIZE; i++){
			 if(board[i][col] >= '1' && board[i][col] <= '9') {
				 if(set[board[i][col] - '1']) return false;
				 else set[board[i][col] - '1'] = true;
			 }else if(board[i][col] != '.') return false;
		 }
		 return true;
	 }
	 
	 //9 grids, from 0 ~ 8
	 private static boolean isValidGrid(char[][] board, boolean[] set, int grid){
		 //clear(set);
		 int row = 3 * (grid / 3);
		 int col = 3 * (grid % 3);
		 for(int i = 0; i < 3; i++){
			 for(int j = 0; j < 3; j++){
				 if(board[row + i][col + j] >= '1' && board[row + i][col + j] <= '9'){
					 if(set[board[row + i][col + j] - '1']) return false;
					 else set[board[row + i][col + j] - '1'] = true;
				 }else if (board[row + i][col + j] != '.') return false;
			 }
		 }
		 return true;
	 }
	 
	 
}

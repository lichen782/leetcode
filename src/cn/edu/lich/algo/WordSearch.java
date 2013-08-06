package cn.edu.lich.algo;

public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board ={
				"aaaa".toCharArray(),
				"aaaa".toCharArray(),
				"aaaa".toCharArray(),
				"aaaa".toCharArray(),
				"aaab".toCharArray(),
		};
		WordSearch ws = new WordSearch();
//		System.out.println(ws.exist(board, "ABCCED"));
//		System.out.println(ws.exist(board, "SEE"));
//		System.out.println(ws.exist(board, "ABCB"));
		System.out.println(ws.exist(board, "aaaaaaaaaaaaaaaaaaaa"));
	}
	
	 public boolean exist(char[][] board, String word) {
		 int m = board.length;
		 int n = m == 0? 0 : board[0].length;
		 if(m == 0 || n == 0 || word.length() > m*n) return false;
		 boolean[][] visited = new boolean[m][n];
	     for(int i = 0; i < m; i++){
	    	 for(int j = 0; j < n; j++){
	    		 if(board[i][j] == word.charAt(0)){
	    			 if(internalSearch(board, visited, word, 0, i, j)) return true;
	    		 }
	    	 }
	     }
	     return false;
	 }
	 
	 private boolean internalSearch(char[][] board, boolean[][] visited, String word, int cur, int row, int col){
		 if(cur == word.length() - 1) return true;
		 visited[row][col] = true;
		 //up
		 if(row > 0 && !visited[row - 1][col] && board[row - 1][col] == word.charAt(cur + 1)){
			 if(internalSearch(board, visited, word, cur + 1, row - 1, col)) return true;
		 }
		 //down
		 if(row < board.length - 1 && !visited[row + 1][col] && board[row + 1][col] == word.charAt(cur + 1)){
			 if(internalSearch(board, visited, word, cur + 1, row + 1, col)) return true;
		 }
		 
		 //left
		 if(col > 0 && !visited[row][col - 1] && board[row][col - 1] == word.charAt(cur + 1)){
			 if(internalSearch(board, visited, word, cur + 1, row, col - 1)) return true;
		 }
		 
		 //right
		 if(col < board[0].length - 1 && !visited[row][col + 1] && board[row][col + 1] == word.charAt(cur + 1)){
			 if(internalSearch(board, visited, word, cur + 1, row, col + 1)) return true;
		 }
		 visited[row][col] = false;
		 return false;
	 }
	
}

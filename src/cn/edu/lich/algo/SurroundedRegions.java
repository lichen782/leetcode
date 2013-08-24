package cn.edu.lich.algo;

import java.util.ArrayList;
import java.util.LinkedList;

public class SurroundedRegions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] board = {
				{X,X,X,X},	
				{X,O,O,X},	
				{X,X,O,X},	
				{X,O,X,X}	
		};
		SurroundedRegions sr = new SurroundedRegions();
		sr.solve(board);
		int rowLength = board.length;
		int colLength = board[0].length;
		for(int row = 0; row < rowLength; row++){
			for(int col = 0; col < colLength; col++){
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}
	
	private static final char MARKED = '-';
	private static final char O = 'O';
	private static final char X = 'X';
	private static class Point {
		int row;
		int col;
		Point(int row_, int col_) {
			row = row_;
			col = col_;
		}
	}
	
	public void solve(char[][] board) {
		int rowLength = board.length;
		if(rowLength == 0) return;
		int colLength = board[0].length;
		for(int i = 0; i < rowLength; i++){
			//first col
			if(board[i][0] == O) bfsMarking(board, i, 0);
		}
		for(int i = 0; i < rowLength; i++){
			//last col
			if(board[i][colLength - 1] == O) bfsMarking(board, i, colLength - 1);
		}
		for(int i = 0; i < colLength; i++){
			//first row
			if(board[0][i] == O) bfsMarking(board, 0, i);
		}
		for(int i = 0; i < colLength; i++){
			//last row
			if(board[rowLength - 1][i] == O) bfsMarking(board, rowLength - 1, i);
		}
		for(int row = 0; row < rowLength; row++){
			for(int col = 0; col < colLength; col++){
				if(board[row][col] == MARKED) board[row][col] = O;
				else board[row][col] = 'X';
			}
		}
	}
	
//	private void dfsMarking(char[][] board, int row, int col){
//		board[row][col] = MARKED; 
//		for(Point point : adjecant(board, row, col)){
//			if(board[point.row][point.col] == O){
//				dfsMarking(board, point.row, point.col);
//			}
//		}
//	}
	
	private void bfsMarking(char[][]board, int row, int col){
		board[row][col] = MARKED;
		LinkedList<Point> queue = new LinkedList<Point>();
		queue.addLast(new Point(row, col));
		while(queue.isEmpty() == false){
			Point p = queue.removeFirst();
			for(Point point : adjecant(board, p.row, p.col)){
				if(board[point.row][point.col] == O){
					board[point.row][point.col] = MARKED;
					queue.add(point);
				}
			}
		}
	}

	private ArrayList<Point> adjecant(char[][]board, int row, int col){
		ArrayList<Point> adjList = new ArrayList<Point>();
		//up
		if(row > 0) adjList.add(new Point(row - 1, col));
		//down
		if(row < board.length - 1) adjList.add(new Point(row + 1, col));
		//left
		if(col > 0) adjList.add(new Point(row, col - 1));
		//right
		if(col < board[0].length - 1) adjList.add(new Point(row, col + 1));
		return adjList;
	}
}

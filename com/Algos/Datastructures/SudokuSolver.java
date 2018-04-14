package com.Algos.Datastructures;

import java.util.stream.*;

public class SudokuSolver {

	public final int BOARD_SIZE = 9;
	public final int BOARD_START_INDEX = 1;
	public final int SUBSECTION_SIZE = 3;
	public final int MIN_VALUE = 1;
	public final int MAX_VALUE = 9;
	
	public boolean checkConstraint(int[][] board, int row, int col, boolean[] constraint) {
		if(board[row][col] != 0) {
			if(!constraint[board[row][col] - 1]) {
				constraint[board[row][col] - 1] = true;
			}
			else {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean rowConstraint(int[][] board, int row) {
		boolean[] constraint = new boolean[BOARD_SIZE];
		return IntStream.range(BOARD_START_INDEX, BOARD_SIZE).allMatch(col -> checkConstraint(board, row, col, constraint));
	}
	
	public boolean colConstraint(int[][] board, int col) {
		boolean[] constraint = new boolean[BOARD_SIZE];
		return IntStream.range(BOARD_START_INDEX, BOARD_SIZE).allMatch(row -> checkConstraint(board, row, col, constraint));
	}
	
	public boolean subSectionConstraint(int[][] board, int col, int row) {
		boolean[] constraint = new boolean[BOARD_SIZE];
		int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
		int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

		int subsectionColStart = (col / SUBSECTION_SIZE) * SUBSECTION_SIZE;
		int subsectionColEnd = subsectionColStart + SUBSECTION_SIZE;

		for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
			for (int c = subsectionColStart; c < subsectionColEnd; c++) {
				if (!checkConstraint(board, subsectionRowEnd, subsectionColEnd, constraint)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isValid(int[][] board, int col, int row) {
		return (this.subSectionConstraint(board, col, row) &&
				this.rowConstraint(board, row)&&
				this.colConstraint(board, col));
	}
	
	public boolean solve(int[][] board) {
		for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
	        for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
	            if (board[row][column] == 0) {
	                for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
	                    board[row][column] = k;
	                    if (isValid(board, row, column) && solve(board)) {
	                        return true;
	                    }
	                    board[row][column] = 0;
	                }
	                return false;
	            }
	        }
	    }
	    return true;
		
		
	}
	
	public void printBoard(int[][] board) {
	    for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {
	        for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
	            System.out.print(board[row][column] + " ");
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {
				  { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
				  { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
				  { 0, 7, 0, 0, 9, 0, 2, 0, 0 },
				  { 0, 5, 0, 0, 0, 7, 0, 0, 0 },
				  { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
				  { 0, 0, 0, 1, 0, 0, 0, 3, 0 },
				  { 0, 0, 1, 0, 0, 0, 0, 6, 8 },
				  { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
				  { 0, 9, 0, 0, 0, 0, 4, 0, 0 } 
				};
		SudokuSolver su = new SudokuSolver();
		su.solve(board);
		su.printBoard(board);
	}

}

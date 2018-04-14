package com.Algos.Datastructures;

import java.util.ArrayList;
import java.util.List;

class Pair{
	int first, second;
	
	public Pair(int i,int j) {
		this.first = i;
		this.second = j;
	}
}

public class SnakeInMatrix {
	
	public static List<Pair> constructPath(int[][] path, int[][] grid, Pair tail){
		List<Pair> route = new ArrayList<Pair>();
		route.add(tail);
		
		int i = tail.first;
		int j = tail.second;
		
		while(path[i][j] != 0) {
			if((i-1 >= 0) && Math.abs(grid[i-1][j] - grid[i][j]) == 1 && 
							(path[i][j] - path[i - 1][j]) == 1) {
				route.add(new Pair(i-1, j));
				i--;
			}
			
			if((j-1 >= 0) && Math.abs(grid[i][j-1] - grid[i][j]) == 1 
					&& (path[i][j] - path[i][j-1]) == 1) {
				route.add(new Pair(i,j-1));
				j--;
			}
		}
		
		return route;
	}
	
	
	
	public static List<Pair> findBiggestSnake(int[][] grid) {
		
		int[][] path = new int[grid.length][grid.length];
		int max_so_far = 0;
		Pair tail = null;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j<grid.length; j++) {
				path[i][j] = 0;
				
				if((i-1 >= 0) && Math.abs(grid[i][j] - grid[i - 1][j]) == 1) {
					path[i][j] = path[i-1][j] + 1;
					if(max_so_far < path[i][j]) {
						max_so_far = path[i][j];
						tail = new Pair(i,j);
					}
				}
				
				if((j-1 >= 0) && Math.abs(grid[i][j] - grid[i][j-1]) == 1) {
					path[i][j] = Integer.max(path[i][j], path[i][j-1] + 1);
					if(max_so_far < path[i][j]) {
						max_so_far = path[i][j];
						tail = new Pair(i,j);
					}
				}
				
				
			}
		}
		return constructPath(path, grid, tail);
		
	}

	
	public static void main(String[] args) {
        int grid [][] = {{1, 2, 1, 2},
                		 {7, 7, 2, 5},
            			 {6, 4, 3, 4},
            			 {1, 2, 2, 5}};
        
        List<Pair> route = findBiggestSnake(grid);
        System.out.println("\nThe Snake unravels as below.");
        for(Pair p: route) {
        	System.out.format("%d->", grid[p.first][p.second]);
        }
	}
}

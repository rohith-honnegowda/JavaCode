package com.Algos.Datastructures;

class TrieNode{
	
	static int MAXSIZE = 26;
	
	TrieNode[] child = new TrieNode[MAXSIZE];
	boolean leaf;
	
	public TrieNode() {
		leaf = false;
		for(int i = 0; i < 26; i++) {
			child[i] = null;
		}
	}
}


public class Boggle {
	static int MAXSIZE = 26;
	static int xlength = 3;
	static int ylength = 3;
	TrieNode root;
	
	public Boggle() {
		root = new TrieNode();
	}
	
	public void insert(TrieNode root, String key) {
		int n = key.length();
		TrieNode nchild = root;
		for(int i = 0; i < n; i++) {
			int index = key.charAt(i) - 'A';
			
			if(nchild.child[index] == null) {
				nchild.child[index] = new TrieNode();
			}
			nchild = nchild.child[index];
		}		
		nchild.leaf = true;
	}
	
	
	public boolean isSafe(int i, int j, boolean visited[][]) {
		return (i >= 0 && i < xlength && j >=0 && j < ylength && !visited[i][j]);
	}
	
	
	public void searchWordAndPrint(TrieNode root, char boggle[][], int i, int j, boolean[][] visited, String str) {
		if(isSafe(i,j,visited)) {
			visited[i][j] = true;
			
			for(int s = 0; s < MAXSIZE; s++) {
				if(root.child[s] != null) {
					char c = (char)(s + 'A');
					if(isSafe(i+1,j+1,visited) && boggle[i+1][j+1] == c) {
						searchWordAndPrint(root.child[s], boggle, i+1, j+1, visited, str+c);
					}
					if(isSafe(i,j+1,visited) && boggle[i][j] == c) {
						searchWordAndPrint(root.child[s], boggle, i, j+1, visited, str+c);
					}
					if(isSafe(i-1,j+1,visited) && boggle[i-1][j+1] == c) {
						searchWordAndPrint(root.child[s], boggle, i-1, j+1, visited, str+c);
					}
					if(isSafe(i-1,j,visited) && boggle[i-1][j] == c) {
						searchWordAndPrint(root.child[s], boggle, i-1, j, visited, str+c);
					}
					if(isSafe(i-1,j-1,visited) && boggle[i-1][j-1] == c) {
						searchWordAndPrint(root.child[s], boggle, i-1, j-1, visited, str+c);
					}
					if(isSafe(i,j-1,visited) && boggle[i][j-1] == c) {
						searchWordAndPrint(root.child[s], boggle, i, j-1, visited, str+c);
					}
					if(isSafe(i+1,j-1,visited) && boggle[i+1][j-1] == c) {
						searchWordAndPrint(root.child[s], boggle, i+1, j-1, visited, str+c);
					}
					if(isSafe(i+1,j,visited) && boggle[i+1][j] == c) {
						searchWordAndPrint(root.child[s], boggle, i+1, j, visited, str+c);
					}
				}
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

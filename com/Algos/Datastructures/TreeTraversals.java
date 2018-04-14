package com.Algos.Datastructures;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversals {
	
	TreeNode root = null;
	
	public void populateTree() {
		root = new TreeNode(100);
		TreeNode twentyFive = new TreeNode(25);
		TreeNode fifty = new TreeNode(50);
		TreeNode seventyfive = new TreeNode(75);
		TreeNode onetwentyfive = new TreeNode(125);
		TreeNode twohundred = new TreeNode(200);
		TreeNode threefifty = new TreeNode(350);
		root.left = fifty;
		root.right = twohundred;
		root.left.left = twentyFive;
		root.left.right = seventyfive;
		root.right.left = onetwentyfive;
		root.right.right = threefifty;
		
		
//		root.left = two;
//		TreeNode three = new TreeNode(3);		
//		root.right = three;;
//		TreeNode four = new TreeNode(4);
//		TreeNode five = new TreeNode(5);
//		two.left = four;
//		two.right = five;
		
	}
	
	
	public void PrintInorderTraversal(TreeNode root) {
		if(root == null) {
			return;
		}
		
		if(root.left != null) {
			PrintInorderTraversal(root.left);
		}
		System.out.print(root.key + "->");
		if(root.right != null) {
			PrintInorderTraversal(root.right);
		}
	}

	public void LevelOrderTraversalOrBreadthFirstSearch(TreeNode root) {
		ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
		if(root == null) {
			System.out.println("Root Node is null, returning");
			return;
		}
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print("Node "+ temp.key + "->");
			
			if(temp.left != null) {
				queue.add(temp.left);
			}
			if(temp.right != null) {
				queue.add(temp.right);
			}
		}
			
	}
	
	
	public void LevelOrderTraversalWithTwoQueues(TreeNode root) {
		if(root == null) {
			System.out.println("Nothing to print, Root is null");
		}
		Queue<TreeNode> currentLevel  = new ArrayDeque<TreeNode>();
		Queue<TreeNode> nextLevel  = new ArrayDeque<TreeNode>();
		
		currentLevel.add(root);
		while(!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
			TreeNode temp = currentLevel.poll();
			
			
			if(temp.left != null) {
				nextLevel.add(temp.left);
			}
			if(temp.right != null) {
				nextLevel.add(temp.right);
			}
			System.out.print("Node "+temp.key + " ->");
			if(currentLevel.isEmpty()) {
				System.out.println();
				while(!nextLevel.isEmpty()) {
					currentLevel.addAll(nextLevel);
					nextLevel.clear();
				}
			}
			
		}
	}
	
	public void getInOrderSuccessor(TreeNode node) {
		if(node.right == null) {
			System.out.println("The Node "+ node.key + " does not have a inorder Successor");
		}
		TreeNode temp = node;
		temp = temp.right;
		while(temp.left != null) {
			temp = temp.left;
		}
		System.out.println("\nThe Node "+ node.key + " has a successor in "+ temp.key+".");
	}
	
	public void IterativeInorderTraversal(TreeNode root) {
		
		TreeNode currentNode = root;
		Stack<TreeNode> traverse = new Stack<TreeNode>();
		traverse.push(currentNode);
		currentNode = currentNode.left;
		while(!traverse.isEmpty() || currentNode != null) {
			if(currentNode != null) {
				traverse.push(currentNode);
				currentNode = currentNode.left;
			} else {
				TreeNode node = traverse.pop();
				System.out.print(node.key + "-");
				currentNode = node.right;
			}
			
		}

//		while(currentNode != null) {
//			traverse.push(currentNode);
//			currentNode = currentNode.left;
//		}
//		if(!traverse.isEmpty()) {
//			System.out.print(traverse.peek().key + "-");
//			currentNode = traverse.pop();
//			if(currentNode.right != null) {
//				while(currentNode != null) {
//					traverse.push(currentNode.right);
//					currentNode = currentNode.right;
//				}
//			}
//		}
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeTraversals tt = new TreeTraversals();
		tt.populateTree();
		//tt.PrintInorderTraversal(tt.root);
		//tt.IterativeInorderTraversal(tt.root);
		//tt.getInOrderSuccessor(tt.root.left);
		//tt.LevelOrderTraversalOrBreadthFirstSearch(tt.root);
		tt.LevelOrderTraversalWithTwoQueues(tt.root);
	}

}

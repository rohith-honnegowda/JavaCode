package com.Algos.Datastructures;

import java.util.Stack;

public class QueuesUsingStacks<Item> {

	private Stack<Item> stack1;
	private Stack<Item> stack2;
	
	public QueuesUsingStacks(){
		stack1 = new Stack<Item>();
		stack2 = new Stack<Item>();
	}
	
	private void moveItemsFromStack() {
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
	}
	
	public int size() {
		return (stack1.size() + stack2.size());
	}
	
	public boolean isEmpty() {
		return (stack1.isEmpty() && stack2.isEmpty());
	}
	
	public Item peek() throws Exception {
		if(isEmpty()) { throw new Exception("Nothing to peek, queue is empty");}
		if(stack2.isEmpty()) {
			moveItemsFromStack();
		}
		return stack2.peek();
	}
	
	public Item dequeue() throws Exception {
		if(isEmpty()) { throw new Exception("Nothing to dequeue, queue is empty");}
		if(stack2.isEmpty()) {
			moveItemsFromStack();
		}
		return stack2.pop();
	}
	
	public void enqueue(Item t) {
		stack1.push(t);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueuesUsingStacks<Double> que = new QueuesUsingStacks<Double>();
		try {
			que.peek();
		}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
		que.enqueue(12.45);
		que.enqueue((double) 30000000);
		que.enqueue((double) 345);
		que.enqueue((double) 2314);
		que.enqueue((double) 832);
		que.enqueue((double) 1234);
		que.enqueue((double) 918);
		
		while(!que.isEmpty()) {
			try {
				System.out.format("%.1f - ", que.dequeue());
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

}

package com.Algos.Datastructures;

import java.util.Hashtable;




public class LRUCache{
	int capacity;
	
	Hashtable<Integer, LinkedListNode> cache;
	LinkedListNode head = null;
	LinkedListNode last = null;
	public LRUCache(int size){
		this.capacity = size;
		cache = new Hashtable<Integer, LinkedListNode>(capacity);
		//cache_vals = new LinkedList<LinkedListNode>();
	}
	
	public void remove(LinkedListNode n) {
		if(n.pre != null) {
			n.pre.next = n.next;
		}else {
			head = n.next;
		}
		
		if(n.next != null) {
			n.next.pre = n.pre;
		}else {
			last = n.pre;
		}
	}
	
	public int get(int key) {
		if(cache.containsKey(key)) {
			LinkedListNode old = cache.get(key);
			remove(old);
			sethead(old);
			return old.data;
		}
		return -1;
	}
	
	public void set(int key, int value) {
		if(cache.contains(key)) {
			LinkedListNode old = cache.get(key);
			old.data = value;
			remove(old);
			sethead(old);
		}else {
			LinkedListNode newNode = new LinkedListNode(key, value);
			if(cache.size()>=capacity) {
				remove(last);
				sethead(newNode);
				cache.remove(key);
			}else {
				sethead(newNode);
			}
			cache.put(key, newNode);
		}
	}
	
	public void sethead(LinkedListNode n) {
		n.next = head;
		n.pre = null;
		if (head != null) {
			head.pre = n;
		}
		head = n;
		if(last == null) {
			last = head;
		}
	}
	

	
	public void print() {
		System.out.println("\nThe current state of the Cache is:");
		LinkedListNode temp = head;
		while(temp.next!=null) {
			System.out.format("%d-%d ", temp.key, temp.data);
			temp = temp.next;
		}
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache= new LRUCache(4);
		cache.set(1, 234);
		cache.set(2, 23476);
		cache.set(3, 898);
		cache.set(4, 978);
		cache.print();
		cache.set(2, 7868);
		cache.print();
	}

}

package data_structure;

public class Stack_List {
	private Node top;
	
	private class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Stack_List() {
		this.top = null;
	}
	
	public void push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;		
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("비었다");
			return -1;
		}
		
		int res = top.data;
		top = top.next;
		
		return res;
	}
	
	public boolean isEmpty() { return (top == null);}
}

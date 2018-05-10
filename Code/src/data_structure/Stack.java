package data_structure;

public class Stack {
	private int top;
	private int size;
	private int [] arr;
	
	public Stack(int size) {
		this.arr = new int[size];
		this.size = size;
		this.top = -1;
	}
	
	public void push(int data) {
		if(isFull()) {
			System.out.println("꽉참!!");
			return;
		}
		
		arr[++top] = data;
		
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("비었다");
			return -1;
		}
		
		return arr[top--];
	}
	
	public boolean isEmpty() { return (top == -1);}
	
	public boolean isFull() { return (top == size-1); }
}

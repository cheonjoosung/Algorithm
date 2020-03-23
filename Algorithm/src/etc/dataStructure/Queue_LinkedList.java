package etc.dataStructure;

public class Queue_LinkedList {
	private Node front;
	private Node rear;
	
	private class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public boolean isEmpty() { return (front == null); }

	public void enQueue(int data) {
		Node newNode = new Node(data);
		newNode.next = null;
		
		if(isEmpty()) {
			rear = newNode;
			front = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	public int deQueue() {
		if(front == null) {
			System.out.println("없다");
			return -1;
		} else {
			int data = front.data;
			front = front.next;
			
			if(front == null) rear = null; //1개만 남았는데 제거 시
			
			return data;
		}
	}
}

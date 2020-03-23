package etc.dataStructure;

public class LinkedList {
	private int size = 0;

	private Node head;
	private Node tail;

	private class Node {
		private int data;
		private Node next;

		public Node(int data) { this.data = data; }
		public int getData() { return this.data; }		
	}
	
	public Node node(int index) { //x번째까지 이동
		Node x = head;
		for(int i=0 ; i<index ; i++) x = x.next;
		return x;
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		size++;

		if(head.next == null) { tail = head; }
	}
	
	public void addLast(int data) {
		Node newNode = new Node(data);
		
		if(size == 0) addFirst(data);
		else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
	}
	
	public void add(int index, int data) {
		if(index == 0) addFirst(index);
		else {
			Node temp1 = node(index-1);
			Node temp2 = temp1.next;
			
			Node newNode = new Node(data);
			
			temp1.next = newNode;
			newNode.next = temp2;
			size++;
			
			if(newNode.next == null) tail = newNode;
		}
	}
	
	public void removeFirst() {
		Node temp = head;
		head = temp.next;
		temp = null;
		size--;
	}
	
	public void remove(int index) {
		if(index == 0) removeFirst();
		else {
			Node temp = node(index-1);
			Node deletedNode = temp.next;
			temp.next = deletedNode.next;
			
			if(deletedNode == tail) { tail = temp; }
			deletedNode = null;
			size--;
		}
	}
	
	public void removeLast() { remove(size - 1); }
	
	public int size() { return this.size; }
	
	public int indexOf(int data) {
		int index = 0;
		
		Node temp = head;
		
		while(temp.data != data) {
			temp = temp.next;
			index++;
			
			if(temp == null) return -1;
		}
		
		return index;
	}

}

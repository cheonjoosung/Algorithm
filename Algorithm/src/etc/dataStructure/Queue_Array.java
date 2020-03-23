package etc.dataStructure;

public class Queue_Array {
	private int front;
	private int rear;
	private int capacity;
	private int [] array;

	public Queue_Array(int size) {
		this.front = -1;
		this.capacity = size;
		this.rear = -1;
		this.array = new int[size];
	}

	public boolean isEmpty() { return (front == -1); }

	public boolean isFull() { return ((rear+1) % capacity == front); }

	public int getQueueSize() { return ((capacity - front + rear + 1) % capacity); }

	public void enQueue(int data) {
		if(isFull()) {
			System.out.println("Full");
		} else {
			rear = (rear+1) % capacity;
			array[rear] = data;
			if(front == -1) front = rear;
		}
	}

	public int deQueue() {
		if(isEmpty()) {
			System.out.println("Empty");
			return -1;
		} else {
			int res = array[front];
			
			if(front == rear) front = rear-1;
			else front = (front+1) % capacity;
			
			return res;
		}
	}
}

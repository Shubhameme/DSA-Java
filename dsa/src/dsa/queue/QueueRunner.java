package dsa.queue;

import java.util.NoSuchElementException;

public class QueueRunner {

	private ListNode front;
	private ListNode rear;
	private int length;
	
	
	public QueueRunner() {
		this.front = null;
		this.rear = null;
		this.length = 0;
	}

	private class ListNode {

		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}

	}

	public int length() {

		return length;
	}

	public boolean isEmpty() {
		return length == 0;
	}
	
	
	public void enqueue(int data) {
		ListNode temp = new ListNode(data);
		if(isEmpty()) {
			front = temp;
			
		}else {
			rear.next = temp;
		}
		
		rear = temp;
		length ++;
	}
	
	public int dequeue() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is already empty");
		}
		int result = front.data;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		length --;
		return result;
	}
	
	public int first() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is already empty");
		}
		
		return front.data;
	}
	public int last() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is already empty");
		}
		
		return rear.data;
	}
	
	
	public void print() {
		if(isEmpty()) {
			return;
		}
		ListNode current = front;
		while(current != null) {
			System.out.print(current.data+ "--->");
			current = current.next;
		}
		System.out.println(" null");
	}

	public static void main(String[] args) {
		
		QueueRunner qrunner = new QueueRunner();
		
	
		qrunner.enqueue(10);
		qrunner.enqueue(256);
		qrunner.enqueue(286);
		qrunner.print();
		
		System.out.println("first: " + qrunner.first());
		System.out.println("last: " + qrunner.last());
	
		

	}

}

package dsa.stack;

import java.util.EmptyStackException;

public class StackUsingArray {
	
	private int[] stack;
	private int top;
	private int capacity;
	
	// Constructor to initialize stack
	public StackUsingArray(int capacity) {
		this.capacity = capacity;
		stack = new int[capacity];
		top = -1; // Initializing top to -1 to indicate the stack is empty
	}
	
	// Method to get the current size of the stack
	public int size() {
		return top + 1;
	}
	
	// Method to check if the stack is empty
	public boolean isEmpty() {
		return top == -1;
	}
	
	// Method to check if the stack is full
	public boolean isFull() {
		return top == capacity - 1;
	}
	
	// Method to push an element onto the stack
	public void push(int data) {
		if (isFull()) {
			throw new StackOverflowError("Stack is full");
		}
		stack[++top] = data;
	}
	
	// Method to pop an element from the stack
	public int pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stack[top--];
	}
	
	// Method to peek the top element of the stack
	public int peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return stack[top];
	}
	
	public static void main(String[] args) {
		StackUsingArray stack = new StackUsingArray(5);
		stack.push(10);
		stack.push(15);
		stack.push(20);
		
		System.out.println("Top element is: " + stack.peek());
		System.out.println("Stack size is: " + stack.size());
		
		stack.pop();
		System.out.println("Top element after pop: " + stack.peek());
	}
}

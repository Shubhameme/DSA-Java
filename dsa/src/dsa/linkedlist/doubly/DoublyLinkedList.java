package dsa.linkedlist.doubly;

import java.nio.file.attribute.AclEntry;
import java.util.NoSuchElementException;

public class DoublyLinkedList {
	// Instance variables
	private ListNode head;
	private ListNode tail;
	private int length; // Integer variable

	// Inner class
	private class ListNode {
		private int data;
		private ListNode next;
		private ListNode previous;

		public ListNode(int data) {
			this.data = data;
		}
	}

	// Constructor
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}

	// Check if the list is empty
	public boolean isEmpty() {
		return length == 0;
	}

	// Get the length of the list
	public int length() {
		return length;
	}

//    // Insert a node at the beginning
//    public void insertFirst(int value) {
//        ListNode newNode = new ListNode(value);
//
//        if (isEmpty()) {
//            // If the list is empty, the new node becomes the head and tail.
//            head = newNode;
//            tail = newNode;
//        } else {
//            // Otherwise, insert the new node before the current head.
//            newNode.next = head; // Set the newNode's next to the current head.
//            head.previous = newNode; // Set the previous head's previous to newNode.
//            head = newNode; // Update head to the new node.
//        }
//        length++;
//    }

	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		if (isEmpty()) {
			tail = newNode;
		} else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}

	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if (isEmpty()) {
			head = newNode;
		} else {
			tail.next = newNode;
			newNode.previous = tail;
		}

		tail = newNode;
		length++;
	}

	// Display the list in forward direction
	public void displayForward() {
		if (head == null) {
			return;
		}
		ListNode temp = head;
		System.out.print("Forward: ");
		while (temp != null) {
			System.out.print(temp.data + " ---> ");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public ListNode deleteFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp = head;
		if (head == tail) {
			tail = null;
		} else {
			head.next.previous = null;

		}
		head = head.next;
		temp.next = null;
		length--;
		return temp;

	}

	
	public ListNode deleteLast() {
		if(isEmpty()) {
			throw new NoSuchElementException("Kya Dekhega tu kuch nahi hai!");
		}
		ListNode temp = tail;
		if(head == tail) {
			head = null;
		}else {
			tail.previous.next = null;
		}
		tail = tail.previous;
		temp.previous = null;
		length --;
		return temp;
	}
	
	
	
	
	// Display the list in backward direction
	public void displayBackward() {
		if (tail == null) {
			return;
		}
		ListNode temp = tail;
		System.out.print("Backward: ");
		while (temp != null) {
			System.out.print(temp.data + " <--- ");
			temp = temp.previous;
		}
		System.out.println("null");
	}

	// Main method for testing
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
//        dll.insertFirst(1);
//        dll.insertFirst(2);
//        dll.insertFirst(3);
		dll.insertFirst(7);
		dll.insertLast(1);
		dll.insertLast(8);
		
		

		dll.displayForward();
//		dll.deleteFirst();
		dll.deleteLast();
		dll.deleteLast();
		dll.deleteLast();
		dll.deleteLast();
		
		dll.displayForward();
//        dll.displayBackward();
	}
}

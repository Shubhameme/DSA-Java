package dsa.linkedlist.doubly;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    // Instance variables
    private ListNode head;
    private ListNode tail;
    private int length;

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

    // Insert a node at the beginning
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

    // Insert a node at the end
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

    // Insert a node at a specific position
    public void insertAtPosition(int position, int value) {
        if (position < 1 || position > length + 1) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (position == 1) {
            insertFirst(value);
            return;
        }
        if (position == length + 1) {
            insertLast(value);
            return;
        }

        ListNode newNode = new ListNode(value);
        ListNode temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        newNode.previous = temp;
        temp.next.previous = newNode;
        temp.next = newNode;
        length++;
    }

    // Delete the first node
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

    // Delete the last node
    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
        ListNode temp = tail;
        if (head == tail) {
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    // Delete a node by value
    public void deleteByValue(int value) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
        ListNode current = head;
        while (current != null) {
            if (current.data == value) {
                if (current == head) {
                    deleteFirst();
                } else if (current == tail) {
                    deleteLast();
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    length--;
                }
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException("Value not found!");
    }

    // Reverse the list
    public void reverse() {
        if (isEmpty()) {
            return;
        }
        ListNode current = head;
        ListNode temp = null;
        while (current != null) {
            temp = current.previous;
            current.previous = current.next;
            current.next = temp;
            current = current.previous;
        }
        if (temp != null) {
            head = temp.previous;
        }
    }

    // Find a node by value
    public boolean find(int value) {
        if (isEmpty()) {
            return false;
        }
        ListNode current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Get node data at a specific position
    public int getNodeAtPosition(int position) {
        if (position < 1 || position > length) {
            throw new IllegalArgumentException("Invalid position");
        }
        ListNode current = head;
        for (int i = 1; i < position; i++) {
            current = current.next;
        }
        return current.data;
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
        dll.insertFirst(7);
        dll.insertLast(1);
        dll.insertLast(8);

        dll.displayForward();
        dll.insertAtPosition(2, 5);
        dll.displayForward();

        dll.deleteByValue(5);
        dll.displayForward();

        dll.reverse();
        dll.displayForward();

        System.out.println("Element at position 2: " + dll.getNodeAtPosition(2));
    }
}

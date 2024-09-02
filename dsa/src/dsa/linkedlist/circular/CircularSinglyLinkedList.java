package dsa.linkedlist.circular;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    // Create a circular linked list with sample data
    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
        length = 4;
    }

    // Display the circular linked list
    public void display() {
        if (last == null) {
            return;
        }

        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.print(first.data);
    }

    // Insert a node at the beginning of the list
    public void insertFirst(int data) {
        ListNode temp = new ListNode(data);
        if (last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
        }
        length++;
    }

    // Insert a node at the end of the list
    public void insertLast(int data) {
        ListNode temp = new ListNode(data);
        if (last == null) {
            last = temp;
            last.next = last;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    // Insert a node at a specific position
    public void insertAtPosition(int position, int data) {
        if (position < 1 || position > length + 1) {
            throw new IllegalArgumentException("Invalid position");
        }

        if (position == 1) {
            insertFirst(data);
            return;
        }

        ListNode temp = new ListNode(data);
        ListNode previous = last.next;
        int count = 1;

        while (count < position - 1) {
            previous = previous.next;
            count++;
        }

        temp.next = previous.next;
        previous.next = temp;

        if (position == length + 1) { // Update last if inserting at the end
            last = temp;
        }

        length++;
    }

    // Delete a node with a specific value
    public void delete(int key) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        ListNode current = last.next;
        ListNode previous = last;

        do {
            if (current.data == key) {
                if (current == last) {
                    last = previous;
                }
                previous.next = current.next;
                current.next = null;
                length--;
                return;
            }
            previous = current;
            current = current.next;
        } while (current != last.next);

        throw new NoSuchElementException("Key not found");
    }

    // Remove the first node from the list
    public ListNode removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Nothing is here");
        }

        ListNode temp = last.next;
        if (last.next == last) { // Only one node in the list
            last = null;
        } else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    // Find a node with a specific value
    public boolean find(int key) {
        if (isEmpty()) {
            return false;
        }

        ListNode current = last.next;
        do {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        } while (current != last.next);

        return false;
    }

    // Check if the list has a cycle (in case it's accidentally turned into a non-circular list)
    public boolean hasCycle() {
        if (isEmpty() || last.next == last) {
            return false;
        }

        ListNode slow = last.next;
        ListNode fast = last.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // Convert the circular linked list to a singly linked list by breaking the circular reference
    public void convertToSinglyLinkedList() {
        if (last != null) {
            ListNode first = last.next;
            last.next = null;
            last = first;
        }
    }

    public static void main(String[] args) {

        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();

        System.out.println("Inserting elements into the circular linked list:");
        csll.insertLast(25);
        csll.insertLast(29);
        csll.insertLast(28);
        csll.insertLast(77);
        csll.display();
        System.out.println();

        System.out.println("Removing the first element:");
        csll.removeFirst();
        csll.removeFirst();
        csll.display();
        System.out.println();

        System.out.println("Inserting an element at position 2:");
        csll.insertAtPosition(2, 55);
        csll.display();
        System.out.println();

        System.out.println("Deleting a node with value 77:");
        csll.delete(77);
        csll.display();
        System.out.println();

        System.out.println("Finding a node with value 28:");
        System.out.println(csll.find(28));

        System.out.println("Checking if the list has a cycle:");
        System.out.println(csll.hasCycle());

        System.out.println("Converting to a singly linked list:");
        csll.convertToSinglyLinkedList();
        csll.display();
    }
}

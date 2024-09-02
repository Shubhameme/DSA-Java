package dsa.linkedlist;

public class SinglyLinkedList {
    private ListNode head;

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at the beginning of the list
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end of the list
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at a specific position
    public void insertAtPosition(int position, int value) {
        if (position == 1) {
            insertFirst(value);
            return;
        }
        ListNode newNode = new ListNode(value);
        ListNode previous = head;
        int count = 1; // Position starts at 1
        while (count < position - 1) {
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;
        previous.next = newNode;
        newNode.next = current;
    }

    // Delete a node
    public void deleteNode(int key) {
        if (head == null) {
            return;
        }
        if (head.data == key) {
            head = head.next;
            return;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current != null && current.data != key) {
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return; // Key not found
        }
        previous.next = current.next;
    }

    // Find a node in the list
    public boolean find(int searchKey) {
        ListNode current = head;
        while (current != null) {
            if (current.data == searchKey) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Reverse the linked list
    public ListNode reverse() {
        if (head == null) {
            return null;
        }

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;  // Save next node
            current.next = previous;  // Reverse the link
            previous = current;  // Move previous to this node
            current = next;  // Move to the next node
        }

        return previous;  // New head of the reversed list
    }

    // Remove duplicates from the list
    public void removeDuplicates() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    // Get the length of the list
    public int length() {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // Find the middle of the list
    public ListNode getMiddle() {
        if (head == null) {
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    // Detect if the list has a loop
    public boolean hasCycle() {
        if (head == null) {
            return false;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
    }

    // Print the elements of the linked list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        // Inserting elements at the beginning
        sll.insertFirst(42);
        sll.insertFirst(42);
        sll.insertFirst(22);
        sll.insertFirst(12);
        sll.insertFirst(12);

        // Inserting an element at the end
        sll.insertLast(99);

        // Inserting an element at position 3
        sll.insertAtPosition(3, 55);

        // Printing the list
        System.out.println("Original List:");
        sll.printList();

        // Removing duplicates
        sll.removeDuplicates();
        System.out.println("After Removing Duplicates:");
        sll.printList();

        // Finding the length of the list
        System.out.println("Length of the list: " + sll.length());

        // Finding the middle element
        System.out.println("Middle element of the list: " + sll.getMiddle().data);

        // Reversing the list
        sll.head = sll.reverse();
        System.out.println("Reversed List:");
        sll.printList();

        // Checking if the list has a cycle
        System.out.println("Does the list have a cycle? " + sll.hasCycle());
    }
}

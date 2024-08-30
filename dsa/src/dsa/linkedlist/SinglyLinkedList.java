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

    // Print the elements of the linked list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("Null");
    }
    
    //Removing the duplicates
    public void removeDuplicates()
    {
    	if(head == null) {
    		return;
    	}
    	ListNode current = head;
    	while(current != null && current.next != null) {
    		if(current.data == current.next.data) {
    			current.next = current.next.next;
    		}else {
    			current = current.next;
    		}
    	}
    }
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();

        // Inserting elements at the beginning
        sll.insertFirst(42);
        sll.insertFirst(42);
        sll.insertFirst(22);
        sll.insertFirst(12);
        sll.insertFirst(12);

        // Printing the list
        System.out.println("Original List:");
//        sll.printList();

        // Reversing the list
//        sll.head = sll.reverse();

        // Printing the reversed list
//        System.out.println("Reversed List:");
//        sll.printList();
        
        sll.removeDuplicates();
        sll.printList();
    }
}

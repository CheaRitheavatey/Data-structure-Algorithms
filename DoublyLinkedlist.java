class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedlist {
    private Node head;

    // Insert a new element at the end of the list
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    // Insert an element at a specific position
    public void insertAt(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            return;
        }
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next = newNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    // Delete an element at a specific position
    public void deleteAt(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }
        Node current = head;
        for (int i = 0; i < position; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
    }

    // Print the linked list from head to tail
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Print the linked list from tail to head
    public void printReverse() {
        Node current = head;
        if (current == null) {
            return;
        }
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Traverse the linked list (same as print)
    public void traverse() {
        print();
    }

    // Main method for testing
    public static void main(String[] args) {
        DoublyLinkedlist list = new DoublyLinkedlist();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.print(); // Output: 10 <-> 20 <-> 30 <-> null

        list.insertAt(15, 1);
        list.print(); // Output: 10 <-> 15 <-> 20 <-> 30 <-> null

        list.deleteAt(2);
        list.print(); // Output: 10 <-> 15 <-> 30 <-> null

        list.printReverse(); // Output: 30 <-> 15 <-> 10 <-> null
    }
}
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class Linkedlist {
    Node head;

    // insert
    public void insert(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            return;
        }

        Node current = head;

        // this is kinda like traversing 
        while (current.next != null) {
            current = current.next;
        }
        current.next = newnode;
    }

    public void insertAt(int data, int position) {
        Node newnode = new Node(data);
        if (position == 0) {
            newnode.next = head;
            head = newnode;
            return;
        }

        Node current = head;
        for (int i =0; i< position -1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        newnode.next = current.next;
        current.next = newnode;
    }
    
}

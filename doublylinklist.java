class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class doublylinklist {
    Node head;

    public void insert(int data) {
        Node newdata = new Node(data);
        // first element
        if (head == null) {
            head = newdata;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newdata;
        newdata.prev = current;

    }

    public void insertAt(int data, int position) {
        Node newdata = new Node(data);

        if (position == 0) {
            newdata.next = head;
            if (head != null) {
                head.prev = newdata;
            }
            head = newdata;
            return;
        }

        Node current = head;
        for (int i =0; i < position-1; i++) {
            while (current == null) {
                System.out.println("Position out of bound");
                return;
            }

            current = current.next;
        }
        newdata.prev = current;
        newdata.next = current.next;
        current.next = newdata;

        if (newdata.next != null) {
            newdata.next.prev = newdata;
        } 

    }

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
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }

            current = current.next;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }

        if (current.next != null) {
            current.next.prev = current.prev;
        }
    }


    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public void printReverse() {
        Node current = head;

        if (current == null) {
            return;
        }

        while (current.next != null) {
            current = current.next;
            System.out.print(current.data + " <-> ");
            current = current.prev;
            if (current.prev == null) {
                break;
            }
        }
        System.out.println("null");   


    }
    public static void main(String[] args) {
        doublylinklist list = new doublylinklist();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.print(); // Output: 10 <-> 20 <-> 30 <-> null

        list.insertAt(15, 1);
        list.print(); // Output: 10 <-> 15 <-> 20 <-> 30 <-> null

        list.deleteAt(2);
        list.print(); // Output: 10 <-> 15 <-> 30 <-> null

        list.printReverse();
    }
    
}

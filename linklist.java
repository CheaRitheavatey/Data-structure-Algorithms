class Node {
    int data;
    Node next;

    Node(int data) {
        this.data =data;
        this.next = null;
    }
}
public class linklist {
    Node head;

    public void insert(int data) {
        Node newData = new Node(data);

        // first element
        if (head == null) {
            head = newData;
            return;
        }

        Node current;
        current = head;
        // insert more element
        while (current.next != null) {
            current = current.next;
        }

        current.next = newData;
    }


    public void insertAt(int data, int position) {
        Node newData = new Node(data);

        if (position == 0) {
            newData.next = head;
            head = newData;
            return;
        }
        
        Node current = head;
        
        for (int i = 0; i< position-1;i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }

            current = current.next;
        }
        newData.next = current.next;
        current.next = newData;

    }
    

    public void deleteAt(int position) {
        // edge case
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        for (int i=0; i < position - 1; i++) {
            if (current == null || current.next == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        current.next = current.next;
    }

    public void print() {
        Node current = head;

        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        linklist list = new linklist();
        list.insert(10);
        list.insert(20);
        list.print();

        list.deleteAt(0);
        list.print();

        list.insertAt(5,0);
        list.print();
    }
}

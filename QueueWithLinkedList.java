class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

class QueuewithLinkedList {
    private Node front;
    private Node rear;

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = front.value;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return value;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
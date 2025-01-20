class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

class StackWoithLinkedList {
    private Node top;

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = top.value;
        top = top.next;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
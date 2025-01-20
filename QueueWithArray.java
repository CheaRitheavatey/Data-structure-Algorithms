class QueueWithArray {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    public QueueWithArray(int size) {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void enqueue(int value) {
        if (nItems < maxSize) {
            rear = (rear + 1) % maxSize;
            queueArray[rear] = value;
            nItems++;
        } else {
            throw new IllegalStateException("Queue is full");
        }
    }

    public int dequeue() {
        if (nItems > 0) {
            int value = queueArray[front];
            front = (front + 1) % maxSize;
            nItems--;
            return value;
        } else {
            throw new IllegalStateException("Queue is empty");
        }
    }

    public boolean isEmpty() {
        return nItems == 0;
    }
}
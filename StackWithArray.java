public class StackWithArray {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackWithArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            throw new StackOverflowError("Stack is full");
        }
    }

    public int pop() {
        if (top >= 0) {
            return stackArray[top--];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public int peek() {
        if (top >= 0) {
            return stackArray[top];
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
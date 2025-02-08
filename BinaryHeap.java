import java.util.Arrays;

public class BinaryHeap {
    private int[] heap;
    private int size;
    private final boolean isMinHeap;

    // Constructor
    public BinaryHeap(int capacity, boolean isMinHeap) {
        this.heap = new int[capacity];
        this.size = 0;
        this.isMinHeap = isMinHeap;
    }

    // Insert a new element into the heap
    public void insert(int value) {
        if (size >= heap.length) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }

    // Remove and return the root element
    public int remove() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int rootValue = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return rootValue;
    }

    // Peek at the root (maximum or minimum value)
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    // Heapify up (for insertion)
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && compare(heap[index], heap[parentIndex])) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // Heapify down (for removal)
    private void heapifyDown(int index) {
        int leftChildIndex, rightChildIndex, selectedChildIndex;

        while (true) {
            leftChildIndex = 2 * index + 1;
            rightChildIndex = 2 * index + 2;
            selectedChildIndex = index;

            if (leftChildIndex < size && compare(heap[leftChildIndex], heap[selectedChildIndex])) {
                selectedChildIndex = leftChildIndex;
            }
            if (rightChildIndex < size && compare(heap[rightChildIndex], heap[selectedChildIndex])) {
                selectedChildIndex = rightChildIndex;
            }
            if (selectedChildIndex == index) {
                break;
            }
            swap(index, selectedChildIndex);
            index = selectedChildIndex;
        }
    }

    // Compare method for min-heap or max-heap
    private boolean compare(int child, int parent) {
        return isMinHeap ? child < parent : child > parent;
    }

    // Swap two elements in the heap
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Print the heap
    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOf(heap, size)));
    }

    // Main method for testing
    public static void main(String[] args) {
        BinaryHeap minHeap = new BinaryHeap(10, true);
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(1);
        minHeap.printHeap();

        System.out.println("Removed: " + minHeap.remove());
        minHeap.printHeap();

        BinaryHeap maxHeap = new BinaryHeap(10, false);
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(20);
        maxHeap.insert(1);
        maxHeap.printHeap();

        System.out.println("Removed: " + maxHeap.remove());
        maxHeap.printHeap();
    }
}
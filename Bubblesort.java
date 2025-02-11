public class Bubblesort {
    public static void bubbleSort(int[] array) {
        int tempt;

        // [3,2,5,6,1]

        // acending order
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                // swap 
                if (array[j] > array[j+1]) {
                    tempt = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tempt;
                    
                }
            }
        }

        
    }

    public static void decendingBubbleSort(int[] array) {

    }

    public static void printArray(int[] array) {
        for (int num: array) {
            System.out.print(num+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr);

        bubbleSort(arr);
        
        System.out.println("Sorted array:");
        printArray(arr);
        

        // worst case O(n^2) = n^2/4 comparisons and swaps
        // best case O(n) = if the array is alrady sorted
        
    }
    
}

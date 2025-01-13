public class ArrayandString {
    public static int findMaxSum(int[] arr, int k) {
        if (arr.length < k) {
            System.out.println("Array length is less than the window size.");
            return -1;
        }

        // Calculate the sum of the first window
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        // Slide the window over the array
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
    public static void twoPointer() {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 6;
        int left = 0, right = arr.length - 1;
    
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("Pair: " + arr[left] + ", " + arr[right]);
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

    }
    public static void string() {
        String str = "Hello world";
        
        // character
        char firstchar = str.charAt(0);
        System.out.println(firstchar);

        // printing out the string
        for (int i =0;i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

        // substring
        String substring = str.substring(0, 5);
        System.out.println(substring);

        // searching
        if (str.contains("world")) {
            System.out.println("yes");
        }
    }
    public static void insertion() {
                // insertion

        // insert num after the first even element in array
        int[] array = {1,2,3,5,7};
        int num = 6;

        // first we need to create new array
        int[] newarray = new int[array.length+1];

        // second we need to copy from old array to new array
        for (int i=0, j=0; i <array.length; i++, j++) {
            newarray[j] = array[i];
            if (array[i] % 2 == 0) {
                newarray[++j] = num;
            }
            
        }

        for (int i=0; i <newarray.length; i++) {
            System.out.println(newarray[i]);
        }
    }
    public static void main(String[] args) {
        string();
        
    }
    
}

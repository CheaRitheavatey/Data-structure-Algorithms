# Data-structure-Algorithms

# this repo is for self-learning data structure and algorithms

# Data structure

1. Arrays:
- basic operation and manipulation:

	- declaration and initialization:
	int[] arr = new int[5]; // Declaration
	int[] arr = {1, 2, 3, 4, 5}; // Initialization

	- accessing element:
	int firstElement = arr[0];

	- updating element:
	arr[2] = 10; // Update third element to 10

	- traversing arrays:
	for (int i = 0; i < arr.length; i++) {
    		System.out.println(arr[i]);
	}

	- common operation:
	1. insertion:
    // Create a new array with one more element
    int[] newArr = new int[arr.length + 1];

    // Copy elements up to the position
    for (int i = 0; i < position; i++) {
        newArr[i] = arr[i];
    }

    // Insert the new element at the specified position
    newArr[position] = elementToInsert;

    // Copy the remaining elements
    for (int i = position; i < arr.length; i++) {
        newArr[i + 1] = arr[i];
    }

    // Print the new array
    for (int i = 0; i < newArr.length; i++) {
        System.out.print(newArr[i] + " ");
    }

    2. deletion:
    // Create a new array with one less element
    int[] newArr = new int[arr.length - 1];

    // Copy elements up to the position
    for (int i = 0; i < position; i++) {
        newArr[i] = arr[i];
    }

    // Copy the remaining elements
    for (int i = position; i < arr.length - 1; i++) {
        newArr[i] = arr[i + 1];
    }

    // Print the new array
    for (int i = 0; i < newArr.length; i++) {
        System.out.print(newArr[i] + " ");
    }
    
    3. search:
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == elementToSearch) {
            System.out.println("Element found at index " + i);
            return;
        }
    }

    System.out.println("Element not found");

2. Strings:
- basic operation and manipulation:

    - declaration and initialization:
    String name = "John"; // Declaration
    String name = "John"; // Initialization

    - accessing element:
    char firstChar = name.charAt(0);

    - updating element:
    name = "Jane"; // Update name to "Jane"

    - traversing strings:
    for (int i = 0; i < name.length(); i++) {
        System.out.println(name.charAt(i));
    }

    - common operation:
    1. concatenation:
    String firstName = "John";
    String lastName = "Doe";
    String fullName = firstName + " " + lastName;

    2. comparison:
    String str1 = "Hello";
    String str2 = "Hello";
    if (str1.equals(str2)) {
        System.out.println("Strings are equal");
    } else {
        System.out.println("Strings are not equal");
    }

    3. length:
    String str = "Hello";
    int length = str.length();
    System.out.println("Length of string: " + length);

    4. substring:
    String str = "Hello";
    String substring = str.substring(2, 4);
    System.out.println("Substring: " + substring);

    5. indexOf:
    String str = "Hello";
    int index = str.indexOf("l");
    System.out.println("Index of 'l': " + index); 

    6. searching:
    String str = "Hello";
    if (str.contains("l")) {
        System.out.println("String contains 'l'"); 
    }

    7. replacing:
    String str = "Hello";
    String replacedStr = str.replace("l", "L");
    System.out.println("Replaced string: " + replacedStr);

    8. split:
    String str = "Hello, World!";
    String[] words = str.split(",");
    for (String word : words) {
        System.out.println(word);
    }

    9. search for a string:
    String str = "Hello";
    if (str.startsWith("H")) {
        System.out.println("String starts with 'H'");
    }
    if (str.endsWith("o")) {
        System.out.println("String ends with 'o'");
    } 

    3. two-pointer algorithm: time complexity: O(n)

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

    4. sliding window algorithm: time complexity: O(n)
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

2. linked list:
 - singly linked list:
    class Node {
        int data;
        Node next;
    } 

    class LinkedList {
        Node head;

        public void add(int data) {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            head = newNode;
        }

        public void print() {
            Node current = head;
            while (current != null) {   
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }   

3. stacks and queues:
    - stack:
        class Stack {
            private List<Integer> stack = new ArrayList<>();

            public void push(int data) {
                stack.add(data);
            }

            public int pop() {
                return stack.remove(stack.size() - 1);
            }
        }

4. trees:
    - binary tree:

    - binary heap: there are 2 max heap and min heap

    max heap is when parent node is greater than or equal to its children

    min heap is when parent node is less than or equal to its childrenf
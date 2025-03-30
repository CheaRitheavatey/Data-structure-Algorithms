package w3resourcesPractice;

public class DataType {
    public static int factorial(int num) {
        //base case
        if (num == 1) return 1;
        return num * factorial(num-1);
    }
    public static int fib(int num) {
        //base case
        if (num == 1) return 1;
        return fib(num-2) + fib(num-1);
    }

    public static void F2C(double fahrenheit) {
        // 1. Convert Fahrenheit to Celsius
    // Write a Java program to convert temperature from Fahrenheit to Celsius degrees.
    // Test Data
    // Input a degree in Fahrenheit: 212
    // Expected Output:
    // 212.0 degree Fahrenheit is equal to 100.0 in Celsius
        double celsius = ((fahrenheit - 32) * 5)/(9);
        System.out.println("Celsius: " + celsius);
    }

    public static void main(String[] args) {
        // F2C(212);
        System.out.println(factorial(4));
    }
}

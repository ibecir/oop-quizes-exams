package ba.edu.ibu.quiz1;

public class LoopsMethodsHarder {
    public static void main(String[] args) {
        printMyCustomShapeWierdShape(5);
    }

    /*
     * 1. This Java program reads input from the user and finds the largest and smallest numbers among them.
     * It repeatedly prompts the user to enter a number and asks if they want to continue.
     * It keeps track of the largest and smallest numbers using the variables max and min,
     * which are initially set to the minimum and maximum possible integer values, respectively.
     * */
    public static void printLargestAndSmallestNumber(int[] numbers) {
        int max = 0, min = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) max = numbers[i];
            if (numbers[i] < min) min = numbers[i];
        }

        System.out.println("Largest Number : " + max);
        System.out.println("Smallest Number : " + min);
    }

    /*
     * 2. The program starts with a checkIsPerfect() method that takes a number as an argument and checks
     * whether it is a Perfect Number or not. It first checks if the number is 1. If it is, the method
     * immediately returns false, as 1 is not considered a Perfect Number. Otherwise, it initializes
     * sum as 1 and then iterates over all the possible divisors of the number up to n-1. For each
     * divisor, it checks if it divides n without leaving a remainder. If it does, it adds it to the sum.
     * */
    public static boolean checkIsPerfect(int n) {
        if (n == 1) return false;
        int sum = 1;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        if (sum == n) return true;

        return false;
    }

    /*
     * 3. Write a  Java program checks whether an input string is a palindrome or not. A palindrome string
     * is a string that remains the same when its characters are reversed.
     * */
    public static boolean checkIsPalindrome(String str) {
        String reversedString = "";
        int len = str.length(); // Add this to the task

        for (int i = (len - 1); i >= 0; --i) {
            reversedString = reversedString + str.charAt(i); // Add this to task
        }

        if (str.toLowerCase().equals(reversedString.toLowerCase())) {
            return true;
        }
        return false;
    }

    /*
     * 4. This Java program checks if a given number is a prime number or not. A prime number is a positive
     * integer greater than 1 that has no positive integer divisors other than 1 and itself. The program
     * starts by importing the Scanner class, which allows the program to read input from the user.
     * The program then creates an instance of the Scanner class and prompts the user to enter a number.
     * The program reads the input number using the nextInt() method of the Scanner class and stores it
     * in the integer variable num.
     * */
    public static boolean checkIfNumberIsPrime(int number) {
        int i, halfNumber = 0, flag = 0;
        halfNumber = number / 2;
        if (number == 0 || number == 1) return false;

        for (i = 2; i <= halfNumber; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
     * 5. Write a method called countEvenOddZeroOccurrences that will accept as a parameter int array
     * of numbers. Then count and write to the console how many of these numbers are even, how many
     * are odd and how of those numbers are zeros. In order to get the length of the array you can
     * use the length property. Ex. numbers.length will return number of elements in array for iteration.
     * In order to access array element at ith index use the square brackets. Ex. numbers[i] where i = 0
     * will return the first array element.
     * */
    public static void countEvenOddZeroOccurrences(int[] numbers) {
        int evenCount = 0, oddCount = 0, zerosCount = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) zerosCount++;
            else if (numbers[i] % 2 == 0) evenCount++;
            else if (numbers[i] % 2 == 1) oddCount++;
        }
        System.out.println("Count of even numbers is: " + evenCount);
        System.out.println("Count of odd numbers is: " + oddCount);
        System.out.println("Count of zeros is: " + zerosCount);
    }

    /*
     * 6. Write a method called calculateGCD that accepts two integer numbers as a parameter and as a response
     * returns the greatest common divider (gcd) of these two numbers. GCD is the greatest positive integer
     * d such that d is a divisor of both a and b. In order to iterate to the smaller of two provided numbers
     * you can as a condition in your for loop you can say following;
     * Ex. suppose i is you loop control variable, your condition will be i <= num1 && i <= num2
     * In this way, the loop will iterate to the number that is smaller of num1 and num2
     * */
    public static int calculateGCD(int num1, int num2) {
        int gcd = 1;

        for (int i = 1; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) gcd = i;
        }
        return gcd;
    }

    /*
     * 7. Write a method called baseRaisedToPower that accepts two input integer parameters base and power.
     * Method should return an integer value of base number raised to the power. (Do not use Java built-in method)
     * */
    public static int baseRaisedToPower(int base, int power) {
        int result = 1;
        for (int i = 1; i <= power; i++) {
            result *= base;
        }
        return result;
    }

    /*
     * 8. Write a method called calculateFactorial that will accept an integer number as a parameter
     * and it will return the integer value of the factorial of the number provided.
     * */
    public static int calculateFactorial(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /*
     * 9. Write a method called printMyCustomShape that accepts as a parameter integer value that represents
     * number of rows that user wants and prints the shape shown.
     *
     * printMyCustomShape(5)
     * 5 10 15 20 25
     * 4 8 12 16
     * 3 6 9
     * 2 4
     * 1
     *
     * printMyCustomShape(7)
     * 7 14 21 28 35 42 49
     * 6 12 18 24 30 36
     * 5 10 15 20 25
     * 4 8 12 16
     * 3 6 9
     * 2 4
     * 1
     * */
    public static void printMyCustomShape(int rows){
        for (int i = rows; i >= 1; i--){
            for (int j = 1; j <= i; j++){
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    /*
     * 10. Write a method called printMyCustomShapeWierdShape that accepts as a parameter integer value that represents
     * number of rows that user wants and prints the shape shown.
     *
     * printMyCustomShapeWierdShape(5)
     * 25 20 15 10 5
     * 16 12 8 4
     * 9 6 3
     * 4 2
     * 1
     *
     * printMyCustomShapeWierdShape(7)
     * 49 42 35 28 21 14 7
     * 36 30 24 18 12 6
     * 25 20 15 10 5
     * 16 12 8 4
     * 9 6 3
     * 4 2
     * 1
     * */
    public static void printMyCustomShapeWierdShape(int rows){
        for (int i = rows; i >= 1; i--){
            for (int j = i; j >= 1; j--){
                System.out.print(j * i + " ");
            }
            System.out.println();
        }
    }
}

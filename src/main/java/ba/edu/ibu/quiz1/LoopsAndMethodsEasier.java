package ba.edu.ibu.quiz1;

public class LoopsAndMethodsEasier {
    public static void main(String[] args) {
        printInvertedTablesNumber(1, 10, 3);
    }

    /*
     * Write a function called divisibleByNine that accepts two integer parameters m and n.
     * Function should find all the numbers between n and m that are divisible
     * by 9 and return their sum.
     * */
    public static int divisibleByNine(int i, int j) {
        int sum = 0;
        for (int k = i; k < j; k++) {
            if (k % 9 == 0) {
                sum += k;
            }
        }
        return sum;
    }

    /*
     * Write a function called sumOfEvenNumbersInRange that accepts two integer parameters i and j.
     * Function should find all the even numbers between i and j that are divisible
     * by 9 and return their sum.
     * */
    public static int sumOfEvenNumbersInRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            if (k % 2 == 0) sum = sum + k;
        }
        return sum;
    }

    /*
     * Write a function called sumOfOddNumbersInRange that accepts two integer parameters i and j.
     * Function should find all the even numbers between i and j that are divisible
     * by 9 and return their sum.
     * */
    public static int sumOfOddNumbersInRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            if (k % 2 == 1) sum = sum + k;
        }
        return sum;
    }

    /*
     * Write a method called numberFactors that accepts as a parameter a number and finds all
     * positive factors of a given number. A factor of a positive integer is a positive integer
     * that divides the given integer without leaving a remainder.
     * */
    public static void numberFactors(int number) {
        for (int i = 1; i <= number; ++i) {
            if (number % i == 0) {
                System.out.println(i);
            }
        }
    }


    /*
     * Write Java function called printWordsFromSentence that accepts as a parameter String sentence
     * and prints to the console all words in the sentence in a new row. Use the split()
     * method to split the string into an array of words, based on the delimiter " " (a space character).
     * */
    public static void printWordsFromSentence(String sentence) {
        String[] words = sentence.split(" ");

        for (String w : words) {
            System.out.println(w);
        }
    }

    /*
     * Write Java function called countWordsInSentence that accepts as a parameter String sentence
     * and returns the amount of words in the sentence. Use the split() method to split the string into an
     * array of words, based on the delimiter " " (a space character).
     * */
    public static int countWordsInSentence(String sentence) {
        String[] words = sentence.split(" ");
        int counter = 0;
        for (String w : words) {
            counter++;
        }

        // System.out.println(words.length); // Even if they use it like this, it is ok for us
        return counter;
    }

    /*
     * Write a function to print the Floyd's triangle. The function should accept a number of rows as a integer parameter
     * Ex.
     *      * * * * *
     *      * * * *
     *      * * *
     *      * *
     *      *
     * */
    public static void printInvertedHalfPyramid(int rows) {
        for (int i = rows; i >= 1; --i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    /*
     * Write a function to print the Floyd's triangle. The function should accept a number of rows as a integer parameter
     * Ex.
     * 1
     * 2 3
     * 4 5 6
     * 7 8 9 10
     * */
    public static void printFloydsTriangle(int rows) {
        int number = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(number + " ");
                number++;
            }
            System.out.println();
        }
    }

    /*
     * Write a function called printTablesNumber that accepts three parameters of type int (start, end, number).
     * Then the function goes from start number to the end number and prints to the console the multiplication table
     * of the number provided.
     * */
    public static void printTablesNumber(int start, int end, int number) {
        while (end >= start) {
            System.out.println(start + " * " + number + " = " + (start * number));
            start++;
        }
    }

    /*
     * Write a function called printInvertedTablesNumber that accepts three parameters of type int (start, end, number).
     * Then the function goes from end number to the start number and prints to the console the multiplication table
     * of the number provided.
     * */
    public static void printInvertedTablesNumber(int start, int end, int number) {
        while (end >= start) {
            System.out.println(end + " * " + number + " = " + (end * number));
            end--;
        }
    }
}


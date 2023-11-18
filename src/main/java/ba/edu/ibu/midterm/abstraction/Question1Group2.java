package ba.edu.ibu.midterm.abstraction;


/*

You are tasked with implementing a system to track the GPA (Grade Point Average) of students. The system should allow for adding points to a student's total and checking the validity of the points based on a specified range.

Implement the PointsProcess abstract class with the following methods:

abstract void addPoints(int points): Adds the given points to the total.
abstract boolean isValidPoints(int minPoints, int maxPoints, int points): Checks if the given points are within the specified range (minPoints to maxPoints inclusive).
Implement the StudentGPA class, which extends PointsProcess:

The class should have a private instance variable total to keep track of the student's total points.
The class should have a private instance variable studentName to store the name of the student.
The class should have a constructor that takes the student's name as a parameter and initializes the total points to 0.0.
Implement the currentPoints method that returns the current total points of the student.
Implement the addPoints method to add the given points to the total and print a message `"Value of X processed."` where the X are the points handled by the addPoints method
Implement the isValidPoints method to check if the given points are within the specified range.


 */
abstract class PointsProcess {
    abstract void addPoints(int points);

    abstract boolean isValidPoints(int minPoints, int maxPoints, int points);
}

class StudentGPA extends PointsProcess {
    private double total;
    private String studentName;

    public StudentGPA(String studentName) {
        this.studentName = studentName;
        this.total = 0.0;
    }

    public double currentPoints() {
        return this.total;
    }

    @Override
    void addPoints(int points) {
        total += points;
        System.out.println("Value of " + points + " processed.");
    }

    @Override
    boolean isValidPoints(int minPoints, int maxPoints, int points) {
        if (points >= minPoints && points <= maxPoints) {
            return true;
        }
        return false;
    }
}

public class Question1Group2 {
    public static void main(String[] args) {

        //test ONE
        StudentGPA studentGpa = new StudentGPA("adnan");
        studentGpa.addPoints(5);
        studentGpa.addPoints(10);
        studentGpa.addPoints(5);
        System.out.println(studentGpa.currentPoints());


        //test TWO
        studentGpa = new StudentGPA("adnan");
        if (studentGpa.isValidPoints(1,100, 50)) {
            System.out.println("Valid points");
        }

        //test THREE
        studentGpa = new StudentGPA("adnan");
        if (!studentGpa.isValidPoints(1,100, 110)) {
            System.out.println("Invalid points");
        }




    }
}

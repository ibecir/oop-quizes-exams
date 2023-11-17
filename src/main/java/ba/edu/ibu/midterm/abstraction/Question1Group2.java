package ba.edu.ibu.midterm.abstraction;


/*

Create an abstract class called PointsProcess with two abstract methods addPoints(int points) and isValidPoints(int minPoints, int maxPoints, int points).

Extend this abstract class in a class called StudentGPA, add a variable total of type int and studentName of type String.
Create a construction that will accept the studentName as a parameter.

Implement the addPoints() method in the StudentGPA class, adding the new points to the total and printing "Value of X processed.".
Implement the isValidPoints() method in the StudentGPA class, checking if the points are valid based on the min and max provided. For valid points return true, otherwise false

Create a method called currentPoints() that returns the current total.


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

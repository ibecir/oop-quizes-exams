package ba.edu.ibu.midterm.abstraction;


/*

Create an abstract class called PointsProcess with an abstract method addPoints(int points).

Extend this abstract class in a class called StudentGPA, add a variable total of type int and studentName of type String.
Create a construction that will accept the studentName as a parameter.

Implement the addPoints() method in the StudentGPA class, adding the new points to the total and printing "Value of X processed.".

Create a method called currentPoints() that returns the current total.


 */
abstract class PointsProcess {
    abstract void addPoints(int points);
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


}

public class Question1Group2 {
    public static void main(String[] args) {
        StudentGPA studentGpa = new StudentGPA("adnan");
        studentGpa.addPoints(5);
        studentGpa.addPoints(10);
        studentGpa.addPoints(5);

        System.out.println(studentGpa.currentPoints());
    }
}

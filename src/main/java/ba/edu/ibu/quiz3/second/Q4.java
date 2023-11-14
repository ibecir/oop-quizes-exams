package ba.edu.ibu.quiz3.second;
/*Create and interface called Walkable that has one abstract method called walk that returns String.

Create class called Student that has one property called yearOfStudy of type int. This class should implement the interface Walkable and implement the method walk, so it returns student walk for the Student class instance. Provide the constructor that gets and sets the value of that property and implement the get and set methods for that property.

Create class called Assistant that has one property called title of type String. This class should implement the interface Walkable and implement the method walk, so it returns Assistant walk for the Assistant class instance. Provide the constructor that gets and sets the value of that property and implement the get and set methods for that property.*/
interface Walkable {
    public String walk();
}

class Student implements Walkable {
    private int yearOfStudy;

    public Student(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public String walk() {
        return "Student walk";
    }
}

class Assistant implements Walkable {
    private String title;

    public Assistant(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String walk() {
        return "Assistant walk";
    }
}

class MainC4 {
    public static void main(String[] args) {
        Student student = new Student(3);
        Assistant assistant = new Assistant("Teaching Assistant");

        System.out.println(student.walk());
        System.out.println(assistant.walk());
    }
}

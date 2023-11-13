package ba.edu.ibu.quiz3.first;
/*Create an abstract class called Person that will have two properties: name of type String and age of type int.  Create a constructor for this class with both of the attributes and get and set methods. Create one abstract method called walk that returns type String. The class should also have method sayHello that returns "Hello".



Create a class called Professor that extends class Person. This class should have one property called title of type String. Provide a constructor for this class that sets the name, age and title (in that same order) and get and set methods. Provide the implementation of the walk method so it, for the Professor class returns "Professor walk".



Create one more class called Student that extends the Person class. This class should have one property called yearOfStudy of type int. Provide a constructor for this class that sets the name, age, and yearOfStudy (in that same order) and get and set methods. Provide the implementation of the walk method so it, for the Student class returns "Student walk".



Create an interface called Classroom that as a parameter has one attribute of generic type called person. This generic can only be an object that inherits from the Person class. Provide the constructor that accepts that generic and sets its value. Provide the get and set methods for it.


*/
abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract String walk();

    public String sayHello(){
        return "Hello";
    }
}

class Professor extends Person{
    private String title;

    public Professor(String name, int age, String title) {
        super(name, age);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String walk(){
        return "Professor walk";
    }
}

class Student extends Person{
    private int yearOfStudy;

    public Student(String name, int age, int yearOfStudy) {
        super(name, age);
        this.yearOfStudy = yearOfStudy;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    @Override
    public String walk(){
        return "Student walk";
    }
}

class Classroom<T extends Person>{
    private T person;

    public Classroom(T person){
        this.person = person;
    }

    public T getPerson(){
        return this.person;
    }
    public void setPerson(T person){
        this.person = person;
    }
}

class MainC4{
    public static void main(String[] args) {
        Classroom<Professor> professorClassroom = new Classroom<>(new Professor("Becir", 29, "Assist. Prof."));
        Classroom<Student> studentClassroom = new Classroom<>(new Student("Becir", 29, 5));

        System.out.println(professorClassroom.getPerson().walk());
        System.out.println(professorClassroom.getPerson().sayHello());
        System.out.println(studentClassroom.getPerson().walk());
    }
}

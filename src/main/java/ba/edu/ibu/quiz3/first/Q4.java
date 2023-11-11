package ba.edu.ibu.quiz3.first;

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

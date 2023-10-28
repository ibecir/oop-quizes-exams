package ba.edu.ibu.quiz2;

/**
 Write a class called Person that will have three attributes: name of type String, age of type int and enum attribute Gender
 (attribute name is gender), values of the Gender enum are: MALE, FEMALE. Create getters and setters for all the attributes.
 Create three constructors: first that accepts and sets the value of the name attribute, second that accepts the and sets the age
 attribute and third that accepts and sets all three of the above-mentioned attributes in the order they have been listed. Create
 one more method called saySomething of the return type String that returns "Person said something" upon calling.

 Create one more class called Student that inherits the Person class and has one more attribute of type String called studentNo and
 provide the get and set method for that attribute. Provide the constructor that sets the value for the field studentNo and calls the
 third parent constructor previously explained (the one with all the fields being set). Also, override the method saySomething so that
 for the Student class it returns String "Student said something". Constructor for Student class should receive parameter as follows:
 public Student(String name, int age, Gender gender, String studentNo)

 Create one more class called Professor that inherits the Person class and has one more attribute of type String called degree and provide
 the get and set method for that attribute. Provide the constructor that sets the value for the field degree and calls the first
 parent constructor previously explained (the one with that accepts and sets the value only for the name attribute). Also, override the
 method saySomething so that for the Professor class it returns String "Professor said something".  Constructor for Professor should receive
 parameters as follows: public Professor(String name, String degree)
 * */

enum Gender {
    MALE, FEMALE
}

class Person {
    private String name;
    private int age;
    private Gender gender;

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String saySomething() {
        return "Person said something";
    }
}

class Student extends Person {
    private String studentNo;

    public Student(String name, int age, Gender gender, String studentNo) {
        super(name, age, gender);
        this.studentNo = studentNo;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public String saySomething() {
        return "Student said something";
    }
}

class Professor extends Person {
    private String degree;

    public Professor(String name, String degree) {
        super(name);
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String saySomething() {
        return "Professor said something";
    }
}

class Run{
    public static void main(String[] args) {
        Professor professor = new Professor("Becir", "PhD");
        System.out.println(professor.saySomething());
    }
}
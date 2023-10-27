package ba.edu.ibu.quiz2;

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
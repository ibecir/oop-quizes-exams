package ba.edu.ibu.quiz3.second;

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

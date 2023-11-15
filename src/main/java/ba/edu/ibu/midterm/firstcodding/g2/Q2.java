package ba.edu.ibu.midterm.firstcodding.g2;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double calculateBonus() {
        return 0.0;
    }
}

class Assistant extends Employee {
    private int yearsOfExperience;

    public Assistant(String name, double salary, int yearsOfExperience) {
        super(name, salary);
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public double calculateBonus() {
        return super.getSalary() * this.yearsOfExperience * 1.1;
    }
}

class Professor extends Employee {
    private String title;

    public Professor(String name, double salary, String title) {
        super(name, salary);
        this.title = title;
    }

    @Override
    public double calculateBonus() {
        return super.getSalary() * 1.8;
    }
}

class Q2Tests {
    public static void main(String[] args) {
        Professor professor = new Professor("Becir", 1000, "My title");
        Assistant assistant = new Assistant("Amila", 999, 1);

        // 0.2
        System.out.println(professor.getName());

        // 0.2
        System.out.println(assistant.getSalary());

        // 0.3
        System.out.println(professor.calculateBonus());

        // 0.3
        System.out.println(assistant.calculateBonus());
    }
}

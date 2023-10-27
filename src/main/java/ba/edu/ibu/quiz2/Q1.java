package ba.edu.ibu.quiz2;

enum Color {
    BLACK, WHITE, RED, GREEN
}

class Animal {
    private String name;
    private int age;

    private Color color;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(int age) {
        this.age = age;
    }

    public Animal(String name, int age, Color color) {
        this.name = name;
        this.age = age;
        this.color = color;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String runSound(){
        return "Animal running";
    }
}

class Tiger extends Animal {
    private int numOfTeeth;

    public Tiger(String name, int age, Color color, int numOfTeeth) {
        super(name, age, color);
        this.numOfTeeth = numOfTeeth;
    }

    public int getNumOfTeeth() {
        return numOfTeeth;
    }

    public void setNumOfTeeth(int numOfTeeth) {
        this.numOfTeeth = numOfTeeth;
    }

    @Override
    public String runSound(){
        return "Tiger running";
    }
}

class Lion extends Animal {
    int bearLength;

    public Lion(String name, int age, int bearLength) {
        super(name);
        this.bearLength = bearLength;
    }

    public int getBearLength() {
        return bearLength;
    }

    public void setBearLength(int bearLength) {
        this.bearLength = bearLength;
    }

    @Override
    public String runSound(){
        return "Lion running";
    }
}
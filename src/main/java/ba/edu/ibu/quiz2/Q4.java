package ba.edu.ibu.quiz2;

enum Colors {
    BLACK, GRAY, YELLOW
}

class Shape {
    private String name;
    private int numOfSides;
    private Colors color;

    public Shape(String name) {
        this.name = name;
    }

    public Shape(int numOfSides) {
        this.numOfSides = numOfSides;
    }

    public Shape(String name, int numOfSides, Colors color) {
        this.name = name;
        this.numOfSides = numOfSides;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfSides() {
        return numOfSides;
    }

    public void setNumOfSides(int numOfSides) {
        this.numOfSides = numOfSides;
    }

    public Colors getColor() {
        return color;
    }

    public void setColor(Colors color) {
        this.color = color;
    }

    public String drawShape(){
        return "Shape drawn";
    }
}

class Cube extends Shape{
    private int height;

    public Cube(String name, int numOfSides, Colors color, int height) {
        super(name, numOfSides, color);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String drawShape(){
        return "Cube drawn";
    }
}

class Rectangle extends Shape {
    private int length;

    public Rectangle(String name, int length) {
        super(name);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String drawShape(){
        return "Rectangle drawn";
    }
}

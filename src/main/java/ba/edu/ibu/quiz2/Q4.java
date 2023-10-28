package ba.edu.ibu.quiz2;

/**
 Write a class called Shape that will have three attributes: name of type String, numOfSides of type int and enum attribute Colors
 (attribute name is color), values of the Colors enum are: BLACK, GRAY, YELLOW. Create getters and setters for all the attributes.
 Create three constructors: first that accepts and sets the value of the name attribute, second that accepts the and sets the numOfSides
 attribute and third that accepts and sets all three of the above-mentioned attributes in the order they have been listed. Create
 one more method called drawShape of the return type String that returns "Shape drawn" upon calling.

 Create one more class called Cube that inherits the Shape class and has one more attribute of type int called height and
 provide the get and set method for that attribute. Provide the constructor that sets the value for the field height and calls the
 third parent constructor previously explained (the one with all the fields being set). Also, override the method drawShape so that
 for the Cube class it returns String "Cube drawn". Constructor for Cube class should receive parameter as follows:
 public Cube(String name, int numOfSides, Colors color, int height)

 Create one more class called Rectangle that inherits the Shape class and has one more attribute of type int called length and provide
 the get and set method for that attribute. Provide the constructor that sets the value for the field length and calls the first
 parent constructor previously explained (the one with that accepts and sets the value only for the name attribute). Also, override the
 method drawShape so that for the Rectangle class it returns String "Rectangle drawn".  Constructor for Rectangle should receive
 parameters as follows: public Rectangle(String name, int length)
 * */

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

class Something{
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("My shape", 1022);
        System.out.println(rectangle.drawShape());
    }
}
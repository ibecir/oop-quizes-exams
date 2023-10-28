package ba.edu.ibu.quiz2;

/**
 Write a class called Animal that will have three attributes: name of type String, age of type int and enum attribute Color
 (attribute name is color), values of the Color enum are: BLACK, WHITE, RED, GREEN. Create getters and setters for all the attributes.
 Create three constructors: first that accepts and sets the value of the name attribute, second that accepts the and sets the age
 attribute and third that accepts and sets all three of the above-mentioned attributes in the order they have been listed. Create
 one more method called runSound of the return type String that returns "Animal running" upon calling.

 Create one more class called Tiger that inherits the Animal class and has one more attribute of type int called numOfTeeth and
 provide the get and set method for that attribute. Provide the constructor that sets the value for the field numOfTeeth and calls the
 third parent constructor previously explained (the one with all the fields being set). Also, override the method runSound so that
 for the Tiger class it returns String "Tiger running". Constructor for Tiger class should receive parameter as follows:
 public Tiger(String name, int age, Color color, int numOfTeeth)

 Create one more class called Lion that inherits the Animal class and has one more attribute of type int called bearLength and provide
 the get and set method for that attribute. Provide the constructor that sets the value for the field bearLength and calls the first
 parent constructor previously explained (the one with that accepts and sets the value only for the name attribute). Also, override the
 method runSound so that for the Lion class it returns String "Lion running".  Constructor for Lion should receive
 public Lion(String name, int bearLength)
 * */

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
    private int bearLength;

    public Lion(String name, int bearLength) {
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

class Smth{
    public static void main(String[] args) {
        try{
            Animal animal = new Animal("Cukica", 11, Color.WHITE);
            System.out.println(animal.getColor());
        } catch(Exception e){
            System.out.println("ERROR");
        }
    }
}

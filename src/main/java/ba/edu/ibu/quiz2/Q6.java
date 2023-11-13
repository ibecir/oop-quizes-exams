package ba.edu.ibu.quiz2;

/**
 Write a class called Component that will have three attributes: name of type String, serialNumber of type int and enum attribute Manufacturer
 (attribute name is manufacturer), values of the Manufacturer enum are: BMW, VW, AUDI. Create getters and setters for all the attributes.
 Create three constructors: first that accepts and sets the value of the name attribute, second that accepts the and sets the serialNumber
 attribute and third that accepts and sets all three of the above-mentioned attributes in the order they have been listed. Create
 one more method called whichComponentAmI of the return type String that returns "Component" upon calling.

 Create one more class called Wheel that inherits the Component class and has one more attribute of type int called diameter and
 provide the get and set method for that attribute. Provide the constructor that sets the value for the field diameter and calls the
 third parent constructor previously explained (the one with all the fields being set). Also, override the method whichComponentAmI so that
 for the Wheel class it returns String "Wheel". Constructor for Wheel class should receive parameter as follows:
 public Wheel(String name, int serialNumber, Manufacturer manufacturer, int diameter)

 Create one more class called Gearbox that inherits the Component class and has one more attribute of type int called numOfGears and provide
 the get and set method for that attribute. Provide the constructor that sets the value for the field numOfGears and calls the first
 parent constructor previously explained (the one with that accepts and sets the value only for the name attribute). Also, override the
 method whichComponentAmI so that for the Gearbox class it returns String "Gearbox".  Constructor for Gearbox should receive
 parameters as follows: public Gearbox(String name, int numOfGears)
 * */

enum Manufacturer {
    BMW, VW, AUDI
}

class Component {
    private String name;
    private int serialNumber;
    private Manufacturer manufacturer;

    public Component(String name) {
        this.name = name;
    }

    public Component(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Component(String name, int serialNumber, Manufacturer manufacturer) {
        this.name = name;
        this.serialNumber = serialNumber;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String whichComponentAmI(){
        return "Component";
    }
}

class Wheel extends Component{
    private int diameter;

    public Wheel(String name, int serialNumber, Manufacturer manufacturer, int diameter) {
        super(name, serialNumber, manufacturer);
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public String whichComponentAmI(){
        return "Wheel";
    }
}

class Gearbox extends Component{
    private int numOfGears;

    public Gearbox(String name, int numOfGears) {
        super(name);
        this.numOfGears = numOfGears;
    }

    public int getNumOfGears() {
        return numOfGears;
    }

    public void setNumOfGears(int numOfGears) {
        this.numOfGears = numOfGears;
    }

    @Override
    public String whichComponentAmI(){
        return "Gearbox";
    }
}

class CmptSmth{
    public static void main(String[] args) {
        Gearbox gearbox = new Gearbox("Component gear", 11);
        System.out.println(gearbox.whichComponentAmI());
    }
}
package ba.edu.ibu.quiz2;

/**
 Write a class called Vehicle that will have three attributes: name of type String, yearOfManufacture of type int and enum attribute DriveType
 (attribute name is driveType), values of the DriveType enum are: BLACK, WHITE, RED, GREEN. Create getters and setters for all the attributes.
 Create three constructors: first that accepts and sets the value of the name attribute, second that accepts the and sets the yearOfManufacture
 attribute and third that accepts and sets all three of the above-mentioned attributes in the order they have been listed. Create one more method
 called makeSound of the return type String that returns "Vehicle sound" upon calling.

 Create one more class called Bicycle that inherits the Vehicle class and has one more attribute of type boolean called isDinamaPresent and
 provide the get and set method for that attribute. Provide the constructor that sets the value for the field isDinamaPresent and calls the
 third parent constructor previously explained (the one with all the fields being set). Also, override the method makeSound so that for the
 Bicycle class it returns String "Bicycle sound". Constructor for Bicycle should receive parameter as follows:
 public Bicycle(String name, int yearOfManufacture, DriveType driveType, boolean isDinamaPresent)

 Create one more class called Car that inherits the Vehicle class and has one more attribute of type int called numOfDoors and provide
 the get and set method for that attribute. Provide the constructor that sets the value for the field numOfDoors and calls the first
 parent constructor previously explained (the one with that accepts and sets the value only for the name attribute). Also, override the
 method makeSound so that for the Car class it returns String "Car sound".  Constructor for Car should receive parameter as follows:
 public Car(String name, int numOfDoors)
 * */

enum DriveType{
    FRONT_WHEEL, BACK_WHEEL, ALL_WHEEL
}

class Vehicle{
    private String name;
    private int yearOfManufacture;
    private DriveType driveType;

    public Vehicle(String name) {
        this.name = name;
    }

    public Vehicle(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Vehicle(String name, int yearOfManufacture, DriveType driveType) {
        this.name = name;
        this.yearOfManufacture = yearOfManufacture;
        this.driveType = driveType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public DriveType getDriveType() {
        return driveType;
    }

    public void setDriveType(DriveType driveType) {
        this.driveType = driveType;
    }

    public String makeSound(){
        return "Vehicle sound";
    }
}

class Bicycle extends Vehicle{
    private boolean isDinamaPresent;

    public Bicycle(String name, int yearOfManufacture, DriveType driveType, boolean isDinamaPresent) {
        super(name, yearOfManufacture, driveType);
        this.isDinamaPresent = isDinamaPresent;
    }

    public boolean isDinamaPresent() {
        return isDinamaPresent;
    }

    public void setDinamaPresent(boolean dinamaPresent) {
        isDinamaPresent = dinamaPresent;
    }

    @Override
    public String makeSound(){
        return "Bicycle sound";
    }
}

class Car extends Vehicle{
    private int numOfDoors;

    public Car(String name, int numOfDoors) {
        super(name);
        this.numOfDoors = numOfDoors;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    @Override
    public String makeSound(){
        return "Car sound";
    }
}

class Runs{
    public static void main(String[] args) {
        Car car = new Car("Moja kola", 5);
        System.out.println(car.makeSound());
    }
}

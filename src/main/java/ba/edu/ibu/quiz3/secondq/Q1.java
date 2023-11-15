package ba.edu.ibu.quiz3.secondq;

/*
Create an abstract class called Vehicle that will have two properties: name of type String and numOfWheels of type int.
Create a constructor for this class with both of the attributes and get and set methods. Create one abstract method called
makeSound that returns type String.

Create a class called Car that extends class Vehicle. This class should have one property called hp of type int. Provide a
constructor for this class that sets the name, numOfWheels and hp (in that same order). Provide the implementation of the
makeSound method so it, for the Car class returns "Car".

Create one more class called Bicycle that extends the Vehicle class. This class should have one property called tiersType of
type String. Provide a constructor for this class that sets the name, numOfWheels and tiersType (in that same order). Provide
the implementation of the  makeSound method so it, for the Car class returns "Bicycle".

Create a generic class called Garage that as a parameter has one attribute of generic type called vehicle. This generic can only
be an object that inherits from the Vehicle class. Provide the constructor that accepts that generic and sets its value. Provide
The get and set methods for it.
* */

abstract class Vehicle {
    private String name;
    private int numOfWheels;

    public Vehicle(String name, int numOfWheels) {
        this.name = name;
        this.numOfWheels = numOfWheels;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumOfWheels() {
        return numOfWheels;
    }

    public void setNumOfWheels(int numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    abstract String makeSound();
}

class Car extends Vehicle{
    private int hp;

    public Car(String name, int numOfWheels, int hp) {
        super(name, numOfWheels);
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String makeSound(){
        return "Car";
    }
}

class Bicycle extends Vehicle{
    private String tiersType;

    public Bicycle(String name, int numOfWheels, String tiersType) {
        super(name, numOfWheels);
        this.tiersType = tiersType;
    }

    public String getTiersType() {
        return tiersType;
    }

    public void setTiersType(String tiersType) {
        this.tiersType = tiersType;
    }

    @Override
    public String makeSound(){
        return "Bicycle";
    }
}

class Garage<T extends Vehicle>{
    private T vehicle;

    public Garage(T vehicle) {
        this.vehicle = vehicle;
    }

    public T getVehicle() {
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }
}

class MainC {
    public static void main(String[] args) {
        Garage<Car> carGarage = new Garage<>(new Car("Benga", 4, 140));
        Garage<Bicycle> bicycleGarage = new Garage<>(new Bicycle("Bemix", 2, "Continental"));
        System.out.println(carGarage.getVehicle().getName());
        System.out.println(carGarage.getVehicle().makeSound());
        System.out.println(bicycleGarage.getVehicle().makeSound());
    }
}

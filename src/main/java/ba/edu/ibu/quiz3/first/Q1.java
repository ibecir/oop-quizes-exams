package ba.edu.ibu.quiz3.first;

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
        return "Car sound";
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

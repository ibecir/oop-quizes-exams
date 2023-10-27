package ba.edu.ibu.quiz2;

enum DriveType{
    FRONT_WHEEL, BACK_WHEEL, ALL_WHEEL
}

class Vehicle{
    private int yearOfManufacture;
    private String numOfWheels;
    private DriveType driveType;

    public Vehicle(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Vehicle(String numOfWheels) {
        this.numOfWheels = numOfWheels;
    }

    public Vehicle(int yearOfManufacture, String numOfWheels, DriveType driveType) {
        this.yearOfManufacture = yearOfManufacture;
        this.numOfWheels = numOfWheels;
        this.driveType = driveType;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getNumOfWheels() {
        return numOfWheels;
    }

    public void setNumOfWheels(String numOfWheels) {
        this.numOfWheels = numOfWheels;
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

    public Bicycle(int yearOfManufacture, String numOfWheels, DriveType driveType, boolean isDinamaPresent) {
        super(yearOfManufacture, numOfWheels, driveType);
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

    public Car(int yearOfManufacture, int numOfDoors) {
        super(yearOfManufacture);
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

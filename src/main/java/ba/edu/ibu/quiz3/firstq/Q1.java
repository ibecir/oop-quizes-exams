package ba.edu.ibu.quiz3.firstq;

/*
Create and interface called Drivable that has one abstract method called drive that returns String.

Create class called Car that has one property called motorSound of type String. This class should
implement the interface Drivable and implement the method drive, so it returns the value of the
motorSound property for the Car class instance. Provide the constructor that gets and sets the value
of that property and implement the get and set methods for that property.

Create class called Scooter that has one property called sound of type String. This class should
implement the interface Drivable and implement the method drive, so it returns the value of sound
property for the Scooter class instance. Provide the constructor that gets and sets the value of
that property and implement the get and set methods for that property.

* */
interface Driveable{
    public String drive();
}
class Car implements Driveable{
    private String motorSound;

    public Car(String motorSound) {
        this.motorSound = motorSound;
    }

    public String getMotorSound() {
        return motorSound;
    }

    public void setMotorSound(String motorSound) {
        this.motorSound = motorSound;
    }

    @Override
    public String drive(){
        return "Car drive";
    }
}

class Scooter implements Driveable{
    private String sound;

    public Scooter(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String drive(){
        return "Scooter drive";
    }
}

class MainC {
    public static void main(String[] args) {
        Car car = new Car("Vrrnnn");
        Scooter scooter = new Scooter("Fijuu");

        System.out.println(car.drive());
        System.out.println(scooter.drive());
    }
}

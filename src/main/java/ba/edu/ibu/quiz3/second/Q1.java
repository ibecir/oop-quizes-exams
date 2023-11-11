package ba.edu.ibu.quiz3.second;

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
        return this.motorSound;
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
        return this.sound;
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

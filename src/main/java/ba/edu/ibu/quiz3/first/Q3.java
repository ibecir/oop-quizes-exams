package ba.edu.ibu.quiz3.first;
/*Create an abstract class called Animal that will have two properties: name of type String and age of type int.

Create a constructor for this class with both of the attributes and get and set methods. Create one abstract method called

makeSound that returns type String. The class should also have method eat that returns "Animal is eating".



Create a class called Tiger that extends class Animal. This class should have one property called numOfTeeth of type int. Provide a

constructor for this class that sets the name, age and numOfTeeth (in that same order) and get and set methods. Provide the implementation of the

makeSound method so it, for the Tiger class returns "Tiger sound".



Create one more class called Sheep that extends the Animal class. This class should have one property called weight of

type int. Provide a constructor for this class that sets the name, age, and weight (in that same order) and get and set methods. Provide

the implementation of the  makeSound method so it, for the Sheep class returns "Sheep sound".



Create generic class called AnimalHouse that as a parameter has one attribute of generic type called animal. This generic can only

be an object that inherits from the Animal class. Provide the constructor that accepts that generic and sets its value. Provide

The get and set methods for it.

*/
abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String makeSound();

    public String eat() {
        return "Animal is eating";
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
}

class Tiger extends Animal {

    private int numOfTeeth;

    public Tiger(String name, int age, int numOfTeeth) {
        super(name, age);
        this.numOfTeeth = numOfTeeth;
    }

    public int getNumOfTeeth() {
        return numOfTeeth;
    }

    public void setNumOfTeeth(int numOfTeeth) {
        this.numOfTeeth = numOfTeeth;
    }

    @Override
    public String makeSound() {
        return "Tiger sound";
    }
}

class Sheep extends Animal {
    private int weight;

    public Sheep(String name, int age, int weight) {
        super(name, age);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String makeSound() {
        return "Sheep sound";
    }
}

class AnimalHouse<T extends Animal> {
    private T animal;

    public AnimalHouse(T animal){
        this.animal = animal;
    }

    public T getAnimal() {
        return animal;
    }

    public void setAnimal(T animal) {
        this.animal = animal;
    }
}

class MainC3 {
    public static void main(String[] args) {
        AnimalHouse<Tiger> tigerAnimalHouse = new AnimalHouse<>(new Tiger("Tigric", 12, 12));
        AnimalHouse<Sheep> sheepAnimalHouse = new AnimalHouse<>(new Sheep("Ovcica", 14, 55));

        System.out.println(tigerAnimalHouse.getAnimal().getNumOfTeeth());
        System.out.println(tigerAnimalHouse.getAnimal().makeSound());
        System.out.println(sheepAnimalHouse.getAnimal().makeSound());
    }
}

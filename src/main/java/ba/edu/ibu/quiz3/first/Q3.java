package ba.edu.ibu.quiz3.first;

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

package ba.edu.ibu.quiz3.second;
/*
Create an interface called Eatable that has one abstract method called eat that returns String.

Create class called Elephant that has one property called name of type String. This class should implement the interface Eatable and implement the method eat,
so it returns the value of the name property for the Elephant class instance and concatenate the string " eating".
Provide the constructor that gets and sets the value of that property and implement the get and set methods for that property.

Create class called Cow that has one property called name of type String. This class should implement the interface Eatable and implement the method eat,
so it returns the value of name property for the Cow class instance and concatenate the string " eat".
Provide the constructor that gets and sets the value of that property and implement the get and set methods for that property.

*/
interface Eatable {
    public String eat();
}

class Elephant implements Eatable {
    private String name;

    public Elephant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String eat() {
        return this.name + " eating";
    }
}

class Cow implements Eatable {
    public String name;

    public Cow(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String eat() {
        return this.name + " eat";
    }
}

class MainC3 {
    public static void main(String[] args) {
        Elephant elephant = new Elephant("Slonic");
        Cow cow = new Cow("Kravica");

        System.out.println(elephant.eat());
        System.out.println(cow.eat());
    }
}

package ba.edu.ibu.midterm.inheritance.g1;

/*
You are tasked with developing a Java program for a simple item tax calculator.
The program includes a base class Item and two subclasses Chocolate and Cigarettes.
Your goal is to implement a system that calculates the tax for each item based on its type.

Item Class:
The Item class represents a generic item and has the following attributes:

- name (String): The name of the item.
- price (int): The price of the item.

It also has the following methods:

- constructor with all arguments - Item(String name, int price)
- get and set methods for both attributes
- calculateTax(): double: A method that calculates and returns the tax for the item. The default implementation returns 0.0.

Chocolate Class:
The Chocolate class extends the Item class and has an additional attribute:

- cocoaPercentage (double): The cocoa percentage in the chocolate.

It also has the constructor for all fields: Chocolate(String name, int price, double cocoaPercentage)
It provides its own implementation of the calculateTax method to calculate the tax for chocolates,
which is 12% (0.12) of the item's price.

Cigarettes Class:
The Cigarettes class also extends the Item class and includes an additional attribute:

- nicotinePercentage (double): The nicotine percentage in the cigarettes.

It also has the constructor for all fields: Cigarettes(String name, int price, double nicotinePercentage)
It overrides the calculateTax method to calculate the tax for cigarettes, which is 89% (0.89) of the item's price.

Your Task:
Implement the Item, Chocolate, and Cigarettes classes as described.
* */

class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double calculateTax() {
        return 0.0;
    }
}

class Chocolate extends Item {
    private double cocoaPercentage;

    public Chocolate(String name, int price, double cocoaPercentage) {
        super(name, price);
        this.cocoaPercentage = cocoaPercentage;
    }

    @Override
    public double calculateTax() {
        return super.getPrice() * 0.12;
    }
}

class Cigarettes extends Item {
    private double nicotinePercentage;

    public Cigarettes(String name, int price, double nicotinePercentage) {
        super(name, price);
        this.nicotinePercentage = nicotinePercentage;
    }

    @Override
    public double calculateTax() {
        return super.getPrice() * 0.89;
    }
}

class Q1Tests{
    public static void main(String[] args) {
        Cigarettes cigarette = new Cigarettes("Malboro", 6, 0.8);
        Chocolate chocolate = new Chocolate("Milka", 3, 22);

        // 0.2
        System.out.println(cigarette.getName());

        // 0.2
        System.out.println(chocolate.getPrice());

        // 0.3
        System.out.println(cigarette.calculateTax());

        // 0.3
        System.out.println(chocolate.calculateTax());
    }
}



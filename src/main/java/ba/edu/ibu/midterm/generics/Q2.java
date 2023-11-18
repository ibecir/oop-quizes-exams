package ba.edu.ibu.midterm.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/*
You are given a set of Java classes representing items, including a base class Item, and two subclasses Fruit and Pasteta.
Item should have two attributes: barcode: int, name: String
Additionally, there is an Order class that is parameterized with a generic type T extending the Item class and
one attribute: items: List<T>
Generate constructor for this Order class that sets the value of items attribute. Implement get and set methods for the items attribute.

Your task is to implement a functionality in the Order class to filter items by name and retrieve an item by its barcode.
The Order class should have two methods:

 - Optional<List<T>> filterByName(String name): This method should filter and return a Optional list of items with the specified name.

 - Optional<T> getByBarcode(int barcode): This method should retrieve and return the Optional of item with the specified barcode.

Your implementation should take advantage of the existing class hierarchy and ensure that the methods work correctly
with objects of the Milk and Honey classes or any other class extending the Item class.
* */

class Item2 {
    private int barcode;
    private String name;

    public Item2(int barcode, String name) {
        this.barcode = barcode;
        this.name = name;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Fruit extends Item2 {
    public Fruit(int barcode, String name) {
        super(barcode, name);
    }
}

class Pasteta extends Item2 {
    public Pasteta(int barcode, String name) {
        super(barcode, name);
    }
}

class Order2<T extends Item2> {
    private List<T> items;

    public Order2(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Optional<List<T>> filterByName(String name) {
        List<T> result = new ArrayList<>();

        for (T item : items) {
            if (item.getName().equals(name))
                result.add(item);
        }
        return Optional.ofNullable(result);
    }

    public Optional<T> getByBarcode(int barcode) {
        for (T item : items) {
            if (item.getBarcode() == barcode)
                return Optional.ofNullable(item);
        }
        return Optional.ofNullable(null);
    }
}

class MainTask {
    public static void main(String[] args) {

        Order2<Item2> order = new Order2<>(Arrays.asList(
                new Fruit(333, "Jabuka"),
                new Fruit(432, "Jabuka"),
                new Pasteta(777, "Argeta")
        ));

        Optional<Item2> i = order.getByBarcode(333);
        System.out.println(i.get().getBarcode());
        Optional<Item2> i2 = order.getByBarcode(432);
        System.out.println(i2.get().getBarcode());

        Optional<List<Item2>> items1 = order.filterByName("Jabuka");
        for (Item2 it : items1.get())
            System.out.println(it.getBarcode());

        Optional<List<Item2>> items2 = order.filterByName("Argeta");
        for (Item2 it2 : items2.get())
            System.out.println(it2.getBarcode());
    }
}

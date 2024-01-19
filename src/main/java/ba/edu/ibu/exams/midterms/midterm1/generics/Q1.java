package ba.edu.ibu.exams.midterms.midterm1.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
You are given a set of Java classes representing items, including a base class Item, and two subclasses Milk and Honey.
Item should have two attributes: barcode: int, name: String
Additionally, there is an Order class that is parameterized with a generic type T extending the Item class and
one attribute: items: List<T>

Your task is to implement a functionality in the Order class to filter items by name and retrieve an item by its barcode.
The Order class should have two methods:

 - List<T> filterByName(String name): This method should filter and return a list of items with the specified name.

 - T getByBarcode(int barcode): This method should retrieve and return the item with the specified barcode.

Your implementation should take advantage of the existing class hierarchy and ensure that the methods work correctly
with objects of the Milk and Honey classes or any other class extending the Item class.
* */

class Item {
    private int barcode;
    private String name;

    public Item(int barcode, String name) {
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

class Milk extends Item {
    public Milk(int barcode, String name) {
        super(barcode, name);
    }
}

class Honey extends Item {
    public Honey(int barcode, String name) {
        super(barcode, name);
    }
}

class Order<T extends Item> {
    private List<T> items;

    public Order(List<T> items) {
        this.items = items;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public List<T> filterByName(String name) {
        List<T> result = new ArrayList<>();

        for (T item : items) {
            if (item.getName().equals(name))
                result.add(item);
        }
        return result;
    }

    public T getByBarcode(int barcode) {
        for (T item : items) {
            if (item.getBarcode() == barcode)
                return item;
        }
        return null;
    }
}

class MainTask1 {
    public static void main(String[] args) {

        Order<Item> order = new Order<>(Arrays.asList(
                new Honey(123, "Med"),
                new Honey(234, "Med"),
                new Milk(444, "Meggle")
        ));

        Item i = order.getByBarcode(444);
        System.out.println(i.getBarcode());
        Item i2 = order.getByBarcode(123);

        List<Item> items1 = order.filterByName("Med");
        for (Item it : items1)
            System.out.println(it.getBarcode());

        List<Item> items2 = order.filterByName("Meggle");
        for (Item it2 : items2)
            System.out.println(it2.getBarcode());
    }
}

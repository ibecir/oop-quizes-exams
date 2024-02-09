package ba.edu.ibu.exams.midterms.midterm3.abstraction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

Problem Statement: Inventory Management System

You are tasked with designing an inventory management system for a warehouse. The system should
allow for the management of different types of products, including electronics and clothing items.

Interfaces and Abstract Classes:

- Define an interface named Product with a method displayDetails(): String.
- Create an abstract class named InventoryItem that implements the Product interface.
This abstract class should include common attributes and methods shared among inventory
items: productName: String, price: double, quantity: int. Create the constructor
that sets all the previously mentioned attributes in order in which they are listed.
Create a get and set methods for all the attributes and follow the encapsulation principle.

Concrete Classes:

Implement concrete classes for different types of products, including ElectronicsProduct and
ClothingProduct,  both extending the InventoryItem abstract class. Override the displayDetails()
method and return "ElectronicsProduct" for the ElectronicsProduct class and "ClothingProduct"
for the ClothingProduct class.

- The ElectronicsProduct should have one attribute: brand: String and you should provide a constructor
to set all the values in following order: String productName, double price, int quantity, String brand.
This class should also follow the encapsulation principle.

- The ClothingProduct should have one attribute: size: String and you should provide a constructor
to set all the values in following order: String productName, double price, int quantity, String size.
This class should also follow the encapsulation principle.

InventoryManager Class:

 - Implement a class named InventoryManager with a method updateInventory(List<InventoryItem> items): List<InventoryItem>
 - Inside this method, iterate through the list of items and adjust their properties. For ElectronicsProduct,
 update its price, so it has 10% discount (multiply the price by 0.9). For ClothingProduct, update its price,
 so it has 20% discount (multiply the price by 0.8) and return the updated List<InventoryItem> of items.
 - Ensure proper downcasting where necessary to access and modify specific attributes of each item.

The goal of the system is to provide a robust solution for managing inventory efficiently, allowing for the addition,
modification, and retrieval of product details with ease.
* */

interface Product {
    String displayDetails();
}

abstract class InventoryItem implements Product {
    private String productName;
    private double price;
    private int quantity;

    public InventoryItem(String productName, double price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ElectronicsProduct extends InventoryItem {
    private String brand;

    public ElectronicsProduct(String productName, double price, int quantity, String brand) {
        super(productName, price, quantity);
        this.brand = brand;
    }

    public String displayDetails() {
        return "ElectronicsProduct";
    }
}

class ClothingProduct extends InventoryItem {
    private String size;

    public ClothingProduct(String productName, double price, int quantity, String size) {
        super(productName, price, quantity);
        this.size = size;
    }

    public String displayDetails() {
        return "ClothingProduct";
    }
}

class InventoryManager {
    public List<InventoryItem> updateInventory(List<InventoryItem> inventory) {
        List<InventoryItem> items = new ArrayList<>();
        for (InventoryItem item : inventory) {
            if (item instanceof ElectronicsProduct) {
                ElectronicsProduct electronicProduct = (ElectronicsProduct) item;
                electronicProduct.setPrice(electronicProduct.getPrice() * 0.9);
                items.add(electronicProduct);
            } else if (item instanceof ClothingProduct) {
                ClothingProduct clothingProduct = (ClothingProduct) item;
                clothingProduct.setPrice(clothingProduct.getPrice() * 0.8);
                items.add(clothingProduct);
            }
        }
        return items;
    }
}

class InventoryManagement {
    public static void main(String[] args) {

        ElectronicsProduct laptop = new ElectronicsProduct("Laptop", 1330, 5, "Dell");
        ClothingProduct tShirt = new ClothingProduct("T-Shirt", 2233, 10, "M");

        // 20% of grade
        System.out.println(laptop.displayDetails());
        System.out.println(tShirt.displayDetails());

        // 20% of grade
        List<InventoryItem> products = Arrays.asList(laptop, tShirt);

        for (InventoryItem i : products)
            System.out.println(i.getPrice());


        // 60% of grade
        InventoryManager manager = new InventoryManager();
        List<InventoryItem> items = manager.updateInventory(products);

        for (InventoryItem i : items)
            System.out.println(i.getPrice());
    }
}


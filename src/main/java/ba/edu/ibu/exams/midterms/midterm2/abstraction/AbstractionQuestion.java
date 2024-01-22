package ba.edu.ibu.exams.midterms.midterm2.abstraction;

import java.util.List;
import java.util.ArrayList;

/*
Question: Implement a Shape hierarchy with an abstract base class and two derived classes,
Circle and Square. Define an interface named Drawable with a method draw() that each shape
should implement. Additionally, create a class named ShapeManager that has a method
drawAll(List<Drawable> shapes) which takes a list of shapes and calls the draw() method
for each shape. Demonstrate upcasting and downcasting in your implementation.

Your implementation should include:

An abstract class Shape with fields and methods common to all shapes.
Two concrete classes Circle and Square that extend the Shape class.
An interface Drawable with a method draw().
A class ShapeManager with a method drawAll(List<Drawable> shapes).
Ensure that you demonstrate the upcasting of Circle and Square instances to Drawable and downcasting back to their original types in your demonstration.
* */
// Step 1: Define an interface
interface Drawable {
    void draw();
}

// Step 2: Create an abstract base class
abstract class Shape implements Drawable {
    // Common fields or methods for all shapes can be added here
}

// Step 3: Create concrete classes
class Circle extends Shape {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }

    // Additional circle-specific methods or fields can be added here
}

class Square extends Shape {
    private int sideLength;

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }

    // Additional square-specific methods or fields can be added here
}

// Step 4: Create a class for managing shapes
class ShapeManager {
    // Method to draw all shapes in the list
    List<Drawable> drawAll(List<Drawable> shapes) {
        List<Drawable> returnedShapes = new ArrayList<>();
        for (Drawable shape : shapes) {
            if(shape instanceof Circle){
                Circle circle = (Circle) shape;
                circle.setRadius(15);
                returnedShapes.add(circle);
            } else if (shape instanceof Square){
                Square square = (Square) shape;
                square.setSideLength(5);
                returnedShapes.add(square);
            }
        }
        return returnedShapes;
    }
}

class Main {
    public static void main(String[] args) {
        // Create instances of Circle and Square
        Circle circle = new Circle();
        Square square = new Square();

        // Upcasting to Drawable
        Drawable drawableCircle = circle;
        Drawable drawableSquare = square;

        // Create a list of Drawable objects
        List<Drawable> shapes = new ArrayList<>();
        shapes.add(drawableCircle);
        shapes.add(drawableSquare);

        // Create a ShapeManager and draw all shapes
        ShapeManager shapeManager = new ShapeManager();
        List<Drawable> drawables = shapeManager.drawAll(shapes);

        for (Drawable drawable : drawables){
            if(drawable instanceof Circle){
                System.out.println("CIRCLE IS " + ((Circle) drawable).getRadius());
            } else if (drawable instanceof Square){
                System.out.println("SQUARE IS " + ((Square) drawable).getSideLength());
            }
        }
    }
}
package ba.edu.ibu.exams.midterms.midterm2.abstraction;

import java.util.List;
import java.util.ArrayList;

/*
Problem Statement: Shape Drawing and Management System

You are required to design a system for drawing and managing shapes. The system should include
an interface for drawing, an abstract base class for shapes, and concrete classes representing
Circle and Square shapes. Additionally, you need to implement a ShapeManager class that can
process a list of shapes and modify them.

Drawable Interface:
- Create an interface named Drawable with a method void draw().

Abstract Base Class:
 - Create an abstract class named Shape that implements the Drawable interface.

Concrete Classes:
 - Create two concrete classes, Circle and Square, that extend the Shape abstract class.
 - Include private attributes such as radius: double for Circle and
   sideLength: double for Square, along with appropriate getter and setter methods.
 - In class Circle, override the method draw() from the interface, so it now prints to the
   console "Drawing Circle"
 - In class Square, override the method draw() from the interface, so it now prints to the
   console "Drawing Square"

ShapeManager Class:
 - Implement a class named ShapeManager with a method drawAll(List<Drawable> shapes): List<Drawable>
 - Inside this method, iterate through the list of shapes and adjust their properties. For Circle shapes,
   set the radius to 15, and for Square shapes, set the side length to 5.

NOTE: In the drawAll method you have to downcast the object, so you are able to change the attribute values
* */
interface Drawable {
    void draw();
}

// Step 2: Create an abstract base class
abstract class Shape implements Drawable { }

// Step 3: Create concrete classes
class Circle extends Shape {
    private double radius;

    public Circle() {
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

class Square extends Shape {
    private double sideLength;

    public Square() {
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class ShapeManager {
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
        Circle circle = new Circle();
        Square square = new Square();

        circle.setRadius(155);
        square.setSideLength(874);

        System.out.println(circle.getRadius());
        System.out.println(square.getSideLength());

        Drawable drawableCircle = circle;
        Drawable drawableSquare = square;

        List<Drawable> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(square);

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

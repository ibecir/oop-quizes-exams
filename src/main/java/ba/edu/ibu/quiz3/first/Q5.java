package ba.edu.ibu.quiz3.first;
/*Create an abstract class called Shape that will have two properties: name and type of type String.  Create a constructor for this class with both of the attributes and get and set methods. Create one abstract method called getArea that returns type int. The class should also have method sayHello that returns "Hello from shape".



Create a class called Square that extends class Shape. This class should have one property called sideLength of type int. Provide a constructor for this class that sets the name, type and sideLength (in that same order) and get and set methods. Provide the implementation of the getArea method so it, for the Square class returns 10.



Create one more class called Circle that extends the Shape class. This class should have one property called radius of type int. Provide a constructor for this class that sets the name, type, and radius (in that same order) and get and set methods. Provide the implementation of the walk method so it, for the Circle class returns 15.



Create an interface called ShapeHouse that as a parameter has one attribute of generic type called shape. This generic can only be an object that inherits from the Shape class. Provide the constructor that accepts that generic and sets its value. Provide the get and set methods for it.*/
abstract class Shape {
    private String name;
    private String type;

    public Shape(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract int getArea();

    public String sayHello() {
        return "Hello from shape";
    }
}

class Square extends Shape {
    public int sideLength;

    public Square(String name, String type, int sideLength) {
        super(name, type);
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public int getArea() {
        return 10;
    }
}

class Circle extends Shape {
    private int radius;

    public Circle(String name, String type, int radius) {
        super(name, type);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public int getArea() {
        return 15;
    }
}

class ShapeHouse<T extends Shape> {
    private T shape;

    public ShapeHouse(T shape) {
        this.shape = shape;
    }

    public T getShape() {
        return shape;
    }

    public void setShape(T shape) {
        this.shape = shape;
    }
}

class Q5 {
    public static void main(String[] args) {
        ShapeHouse<Circle> circleShapeHouse = new ShapeHouse<>(new Circle("Circle", "Type", 11));
        ShapeHouse<Square> squareShapeHouse = new ShapeHouse<>(new Square("Square", "My type", 5));

        System.out.println(circleShapeHouse.getShape().sayHello());
        System.out.println(circleShapeHouse.getShape().getArea());
        System.out.println(squareShapeHouse.getShape().getArea());
    }
}



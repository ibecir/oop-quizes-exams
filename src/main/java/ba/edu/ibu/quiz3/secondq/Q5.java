package ba.edu.ibu.quiz3.secondq;

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



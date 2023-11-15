package ba.edu.ibu.quiz3.second;
/*Create and interface called Drawable that has one abstract method called drive that returns String.

Create class called Rectangle that has one property called shape of type String. This class should implement the interface Drawable and implement the method draw,
so it returns the value of the shape property for the Rectangle class instance.
Provide the constructor that gets and sets the value of that property and implement the get and set methods for that property.

Create class called Triangle that has one property called area of type int. This class should implement the interface Drawable and implement the method draw,
so it returns the value of property for the Triangle class instance.
Provide the constructor that gets and sets the value of that property and implement the get and set methods for that property.*/
interface Drawable {
    public String draw();
}

class Rectangle implements Drawable {
    private String shape;

    public Rectangle(String shape) {
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @Override
    public String draw() {
        return "Draw Rectangle";
    }
}

class Triangle implements Drawable {
    private int area;

    public Triangle(int area) {
        this.area = area;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    @Override
    public String draw() {
        return "Draw Triangle ";
    }
}

class Main5 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle("Rectangle");
        Triangle triangle = new Triangle(10);

        System.out.println(rectangle.draw());
        System.out.println(triangle.draw());
    }
}

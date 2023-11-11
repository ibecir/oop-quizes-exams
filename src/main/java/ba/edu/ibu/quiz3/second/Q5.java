package ba.edu.ibu.quiz3.second;

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
        return "Draw rectangle";
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
        return "Triangle rectangle";
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

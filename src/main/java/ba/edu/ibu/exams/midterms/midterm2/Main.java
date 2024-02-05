package ba.edu.ibu.exams.midterms.midterm2;

import java.util.List;
import java.util.ArrayList;
interface Drawable{
    void draw();
}
abstract class Shape implements Drawable{

}
class Circle extends Shape{
    public Circle(){}
    private double radius;
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    @Override
    public void draw(){
        System.out.println("Drawing Circle");
    }
}
class Square extends Shape{
    public Square(){}
    public double sideLength;
    public double getSideLength(){
        return sideLength;
    }
    public void setSideLength(double sideLength){
        this.sideLength=sideLength;
    }
    @Override
    public void draw(){
        System.out.println("Drawing Square");
    }
}
class ShapeManager {
    List<Drawable> shapes;
    public ShapeManager(List<Drawable> shapes){
        this.shapes=shapes;
    }
    public List<Drawable> drawAll(List<Drawable> shapes){
        for(Drawable d:shapes){
            if(d instanceof Circle){
                Circle c = (Circle) d;
                c.setRadius(15);
            }
            if(d instanceof Square){
                Square s = (Square) d;
                s.setSideLength(5);
            }
        }
        return shapes;

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

        ShapeManager shapeManager = new ShapeManager(shapes);
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
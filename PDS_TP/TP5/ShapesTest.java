package TP5;
import Shape;
import ShapeFactory;

import TP5.ShapeFactory;

public class ShapesTest {

    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.createShape("Circle");
        Shape shape2 = ShapeFactory.createShape("Rectangle");
        Shape shape3 = ShapeFactory.createShape("Triangle");
        shape1.getShape();
        shape1.getArea();
        shape1.getPerimeter();
        shape2.getShape();
        shape2.getArea();
        shape2.getPerimeter();
        shape3.getShape();
        shape3.getArea();
        shape3.getPerimeter();
    }
    
}

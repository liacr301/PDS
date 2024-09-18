package TP13.Visitor;

public class InfoVisitor implements Visitor{
    @Override
    public void visit(Circle circle) {
        System.out.println("Visiting circle with radius: " + circle.getRadius());
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Visiting rectangle with width: " + rectangle.getWidth() + " and height: " + rectangle.getHeight());
    }
}

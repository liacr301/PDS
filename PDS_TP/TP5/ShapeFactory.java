package TP5;
public class ShapeFactory {
    public static Shape createShape(String shape){
        if(shape.equals("Circle")){
            return new Circle();
        } else if (shape.equals("Rectangle")){
            return new Rectangle();
        } else if (shape.equals("Triangle")) {
            return new Triangle();
        } else {
            return null;
        }

    }
}

    interface Shape{
        void getShape();
        void getArea();
        void getPerimeter();
    }

    class Circle implements Shape{
        public void getShape(){
            System.out.println("This is a Circle");
        }
        public void getArea(){
            System.out.println("Area of the Circle");
        }
        public void getPerimeter(){
            System.out.println("Perimeter of the Circle");
        }
    }

    class Rectangle implements Shape{
        public void getShape(){
            System.out.println("This is a Rectangle");
        }
        public void getArea(){
            System.out.println("Area of the Rectangle");
        }
        public void getPerimeter(){
            System.out.println("Perimeter of the Rectangle");
        }
    }

    class Triangle implements Shape{
        public void getShape(){
            System.out.println("This is a Triangle");
        }
        public void getArea(){
            System.out.println("Area of the Triangle");
        }
        public void getPerimeter(){
            System.out.println("Perimeter of the Triangle");
        }
    }


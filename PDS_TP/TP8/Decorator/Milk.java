package Decorator;

public class Milk extends CoffeeDecorator {

   
    public Milk(Coffee coffee) {
        super(coffee);
    }
    
    public double getCost() {
        return super.getCost() + 1.5;
    }

    public String getDescription() {
        return super.getDescription() + "Milk";
    }
    
}

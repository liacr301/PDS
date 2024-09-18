package Decorator;

public class Caramel extends CoffeeDecorator{


    public Caramel(Coffee coffee) {
        super(coffee);
    }
    
    public double getCost() {
        return super.getCost() + 2.0;
    }
    
    public String getDescription() {
        return super.getDescription() + "Caramel";
    }

}

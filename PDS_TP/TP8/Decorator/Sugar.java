package Decorator;

public class Sugar extends CoffeeDecorator{

    public Sugar(Coffee coffee) {
        super(coffee);
    }

    public Coffee getCoffee() {
        return this.coffee;
    }
    
    public double getCost() {
        return super.getCost() + 0.5;
    }
    
    public String getDescription() {
        return super.getDescription() + "Sugar";
    }
}

package Decorator;

public class Client {
    
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println("Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getDescription());
        
        coffee = new Milk(coffee);
        System.out.println("Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getDescription());
        
        coffee = new Sugar(coffee);
        System.out.println("Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getDescription());
        
        coffee = new Caramel(coffee);
        System.out.println("Cost: " + coffee.getCost() + "; Ingredients: " + coffee.getDescription());
    }
}

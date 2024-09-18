package lab10.Ex2_ChainOfResponsability;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
		
        List<String> ordersList = new ArrayList<>();
        
        ordersList.add("veggie burger");
        ordersList.add("Pasta Carbonara");
        ordersList.add("PLAIN pizza, no toppings!");
        ordersList.add("sushi nigiri and sashimi");
        ordersList.add("salad with tuna");
        ordersList.add("strawberry ice cream and waffles dessert");

        Chef Chef = new SushiChef().setSucessor(new PastaChef()
                    .setSucessor(new BurgerChef().setSucessor(
                    new PizzaChef().setSucessor(new DessertChef()))));

        for (String order : ordersList) {
            System.out.println("Can I please get a " + order + "?");
            Chef.Chef(order);
            System.out.println();
        }
    }

}

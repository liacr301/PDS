package TP6;

public class PizzaDemo {
    public static void main(String[] args) {
        PizzaBuilder pizza_veggie = new VeggiePizzaBuilder();

        Waiter pizza_waiter = new Waiter();

        pizza_waiter.setBuilder(pizza_veggie);

        pizza_waiter.construct(("Veggie"));

        Pizza veggie_pizza = pizza_veggie.getPizza();

        System.out.println(veggie_pizza);

    }
}

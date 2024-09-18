package TP6;

public class Waiter {
    private PizzaBuilder pizza_builder;
    
    public void setBuilder(PizzaBuilder pizza_builder) {
        this.pizza_builder = pizza_builder;
    }

    public void construct(String type) {
        if (type.equals("Hawaian")) {
            this.pizza_builder = new HawaianPizzaBuilder();
        } else if (type.equals("Veggie")) {
            this.pizza_builder = new VeggiePizzaBuilder();
        } else if (type.equals("Spicy")) {
            this.pizza_builder = new SpicyPizzaBuilder();
        }
    }

    public Pizza getPizza() {
        return this.pizza_builder.getPizza();
    }
}

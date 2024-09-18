package TP6;

public class VeggiePizzaBuilder implements PizzaBuilder{
    private Pizza pizza;

    public VeggiePizzaBuilder() {
        pizza = new Pizza();
    }

    public void setDough() {
        this.pizza.setDough("thin");
    }

    public void setSauce() {
        this.pizza.setSauce("tomato");
    }

    public void setTopping() {
        this.pizza.setTopping("mushrooms+peppers+onions+olives");
    }

    public Pizza getPizza() {
        return pizza;
    }
}

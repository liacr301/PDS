package TP6;

public class SpicyPizzaBuilder implements PizzaBuilder{
    private Pizza pizza;

    public SpicyPizzaBuilder() {
        pizza = new Pizza();
    }

    public void setDough() {
        this.pizza.setDough("pan");
    }

    public void setSauce() {
        this.pizza.setSauce("tomato+hotsauce");
    }

    public void setTopping() {
        this.pizza.setTopping("pepperoni+salami+onions+olives+cheese");
    }

    public Pizza getPizza() {
        return pizza;
    }
}

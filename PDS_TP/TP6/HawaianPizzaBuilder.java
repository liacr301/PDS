package TP6;

public class HawaianPizzaBuilder implements PizzaBuilder{

    private Pizza pizza;

    public HawaianPizzaBuilder() {
        pizza = new Pizza();
    }

    public void setDough() {
        this.pizza.setDough("thin");
    }

    public void setSauce() {
        this.pizza.setSauce("barbacue");
    }

    public void setTopping() {
        this.pizza.setTopping("pinaple+ham+onions+olives+cheese");
    }

    public Pizza getPizza() {
        return pizza;
    }
}

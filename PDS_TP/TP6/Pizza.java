package TP6;

public class Pizza {
    private String dough;
    private String sauce;
    private String topping;

    public Pizza() {
    }
    
    public void setDough(String dough) {
        this.dough = dough;
    }
    
    public void setSauce(String sauce) {
        this.sauce = sauce;
    }
    
    public void setTopping(String topping) {
        this.topping = topping;
    }
    
    public String toString() {
        return "Pizza with " + dough + " dough, " + sauce + " sauce and " + topping + " topping.";
    }
    
}
